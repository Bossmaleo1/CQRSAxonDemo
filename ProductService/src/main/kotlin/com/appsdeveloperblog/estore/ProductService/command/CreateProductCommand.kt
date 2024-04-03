package com.appsdeveloperblog.estore.ProductService.command

import lombok.Builder
import lombok.Data
import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal

@Builder
@Data
class CreateProductCommand {

    @TargetAggregateIdentifier
    var productId: String? = null
    var title: String? = null
    var price: BigDecimal? = null
    var quantity: Int? = null

}