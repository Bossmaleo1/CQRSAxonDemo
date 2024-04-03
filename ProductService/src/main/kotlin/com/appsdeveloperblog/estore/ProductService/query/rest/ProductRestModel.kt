package com.appsdeveloperblog.estore.ProductService.query.rest

import lombok.Data
import java.math.BigDecimal

@Data
class ProductRestModel {
    var productId: String? = null
    var title: String? = null
    var price: BigDecimal? = null
    var quantity: Int? = null
}