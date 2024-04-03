package com.appsdeveloperblog.estore.ProductService.command.rest

import com.appsdeveloperblog.estore.ProductService.command.CreateProductCommand
import jakarta.validation.Valid
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/products")
class ProductsCommandController(
    @Autowired
    val env: Environment,
    @Autowired
    val commandGateway: CommandGateway) {


    @PostMapping
    fun createProduct(@Valid @RequestBody createProductRestModel: CreateProductRestModel): String {

        val createProductCommand = CreateProductCommand()
        createProductCommand.productId = UUID.randomUUID().toString()
        createProductCommand.price = createProductRestModel.price
        createProductCommand.title = createProductRestModel.title
        createProductCommand.quantity = createProductRestModel.quantity

        println("Title 1 :${createProductCommand.title}")

        val returnValue: String = commandGateway.sendAndWait(createProductCommand)
        /*try {
            returnValue = commandGateway.sendAndWait(createProductCommand)
        } catch (ex: Exception) {
            returnValue = ex.localizedMessage
        }*/

        return returnValue
    }

    /*@GetMapping
    fun getProduct(): String {
        return "HTTP GET Handled ${env.getProperty("local.server.port")}"
    }

    @PutMapping
    fun updateProduct(): String {
        return "HTTP PUT Handled"
    }

    @DeleteMapping
    fun deleteProduct(): String {
        return "HTTP DELETE handled"
    }*/
}