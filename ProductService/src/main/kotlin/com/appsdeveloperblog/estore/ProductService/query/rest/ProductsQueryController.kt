package com.appsdeveloperblog.estore.ProductService.query.rest

import com.appsdeveloperblog.estore.ProductService.query.FindProductsQuery
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsQueryController(
    @Autowired
    val queryGateway: QueryGateway
) {

    @GetMapping
    fun getProducts(): List<ProductRestModel> {
        val findProductsQuery = FindProductsQuery()
        val products: List<ProductRestModel> = queryGateway.query(findProductsQuery,
            ResponseTypes.multipleInstancesOf(ProductRestModel::class.java)).join()
        return products
    }
}