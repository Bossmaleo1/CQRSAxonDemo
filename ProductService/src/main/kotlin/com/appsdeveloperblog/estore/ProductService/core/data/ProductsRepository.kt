package com.appsdeveloperblog.estore.ProductService.core.data

import org.springframework.data.jpa.repository.JpaRepository


interface ProductsRepository : JpaRepository<ProductEntity, String> {

    fun findByProductId(productId: String): ProductEntity

    fun findByProductIdOrTitle(productId: String, title: String): ProductEntity

}