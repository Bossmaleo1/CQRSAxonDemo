package com.appsdeveloperblog.estore.ProductService.command.interceptor

import com.appsdeveloperblog.estore.ProductService.command.CreateProductCommand
import com.appsdeveloperblog.estore.ProductService.core.data.ProductLookupEntity
import com.appsdeveloperblog.estore.ProductService.core.data.ProductLookupRepository
import org.axonframework.commandhandling.CommandMessage
import org.axonframework.messaging.MessageDispatchInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.function.BiFunction


@Component
class CreateProductCommandInterceptor(productLookupRepository: ProductLookupRepository) :
    MessageDispatchInterceptor<CommandMessage<*>> {
    private val productLookupRepository: ProductLookupRepository = productLookupRepository

    override fun handle(
        messages: List<CommandMessage<*>>
    ): BiFunction<Int, CommandMessage<*>, CommandMessage<*>> {
        return BiFunction<Int, CommandMessage<*>, CommandMessage<*>> { _: Int?, command: CommandMessage<*> ->
            LOGGER.info("Intercepted command: " + command.payloadType)
            if (CreateProductCommand::class.java == command.payloadType) {
                val createProductCommand = command.payload as CreateProductCommand

                val productLookupEntity: ProductLookupEntity? = productLookupRepository.findByProductIdOrTitle(
                    createProductCommand.productId,
                    createProductCommand.title
                )

                check(productLookupEntity == null) {
                    String.format(
                        "Product with productId %s or title %s already exist",
                        createProductCommand.productId, createProductCommand.title
                    )
                }
            }
            command
        }
    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(CreateProductCommandInterceptor::class.java)
    }
}