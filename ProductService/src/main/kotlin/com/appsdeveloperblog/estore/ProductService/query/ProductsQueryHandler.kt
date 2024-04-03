package com.appsdeveloperblog.estore.ProductService.query

import com.appsdeveloperblog.estore.ProductService.core.data.ProductEntity
import com.appsdeveloperblog.estore.ProductService.core.data.ProductsRepository
import com.appsdeveloperblog.estore.ProductService.query.rest.ProductRestModel
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class ProductsQueryHandler(productsRepository: ProductsRepository) {
    private var productsRepository: ProductsRepository? = productsRepository

    @QueryHandler
    fun findProducts(query: FindProductsQuery): List<ProductRestModel> {
        val productsRest : MutableList<ProductRestModel> = ArrayList<ProductRestModel>()

        val storedProducts: List<ProductEntity> = productsRepository!!.findAll()
        for(productEntity in storedProducts) {
            val productRestModel = ProductRestModel()
            BeanUtils.copyProperties(productEntity, productRestModel)
            productsRest.add(productRestModel)
        }

        return productsRest
    }
}