package com.appsdeveloperblog.estore.ProductService.query

import com.appsdeveloperblog.estore.ProductService.core.data.ProductEntity
import com.appsdeveloperblog.estore.ProductService.core.data.ProductsRepository
import com.appsdeveloperblog.estore.ProductService.core.events.ProductCreateEvent
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
@ProcessingGroup("product-group")
class ProductEventsHandler(productsRepository: ProductsRepository) {

   private var productsRepository: ProductsRepository? = productsRepository

    @EventHandler
    fun on(event: ProductCreateEvent) {
        val productEntity = ProductEntity()
        BeanUtils.copyProperties(event, productEntity)
        println("Title 2 :${productEntity.title}")

        productsRepository?.save(productEntity)
    }
}