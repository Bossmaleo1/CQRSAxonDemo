package com.appsdeveloperblog.estore.ProductService.core.events

import lombok.Data
import java.math.BigDecimal

@Data
class ProductCreateEvent {

    var productId: String? = null
    var title: String? = null
    var price: BigDecimal? = null
    var quantity: Int? = null
}