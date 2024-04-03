package com.appsdeveloperblog.estore.ProductService.command

import com.appsdeveloperblog.estore.ProductService.core.events.ProductCreateEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.springframework.beans.BeanUtils
import java.math.BigDecimal

@Aggregate
class ProductAggregate {

    @AggregateIdentifier
    var productId: String? = null
    var title: String? = null
    var price: BigDecimal? = null
    var quantity: Int? = null

    constructor() {

    }
    @CommandHandler
    constructor(createProductCommand: CreateProductCommand) {

        if(createProductCommand.price?.compareTo(BigDecimal.ZERO)!! <= 0) {
            throw IllegalArgumentException("Price cannot be less or equal than zero")
        }

        println("nous avons rien du tout ici !!")
        println(createProductCommand)

        if (createProductCommand.title!!.isEmpty() ||
            createProductCommand.title!!.isBlank()) {
            throw IllegalArgumentException("Title cannot be empty")
        }

        val productCreateEvent = ProductCreateEvent()
        // Notre objet de destination est un évenement crée par le produit
        BeanUtils.copyProperties(createProductCommand, productCreateEvent)

        AggregateLifecycle.apply(productCreateEvent)
    }

    // Cette méthode est utilisée pour actualiser l'état actuel
    @EventSourcingHandler
    fun on(productCreateEvent: ProductCreateEvent) {
        this.productId = productCreateEvent.productId
        this.price = productCreateEvent.price
        this.title = productCreateEvent.title
        this.quantity = productCreateEvent.quantity
    }
}