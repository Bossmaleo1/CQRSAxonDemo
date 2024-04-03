package com.appsdeveloperblog.estore.ProductService.core.data

import org.springframework.data.jpa.repository.JpaRepository


interface ProductLookupRepository : JpaRepository<ProductLookupEntity?, String?> {
    fun findByProductIdOrTitle(productId: String?, title: String?): ProductLookupEntity?
}