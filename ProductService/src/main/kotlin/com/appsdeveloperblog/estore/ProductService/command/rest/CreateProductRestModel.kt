package com.appsdeveloperblog.estore.ProductService.command.rest

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import lombok.Data
import java.math.BigDecimal

@Data
class CreateProductRestModel {

     @NotBlank(message = "Product title is a required field")
     var title: String? = null

     @Min(value = 1, message = "Price cannot be lower than 1")
     var price: BigDecimal? = null

     @Min(value = 1, message = "Quantity cannot be lower than 1")
     @Max(value = 5, message = "Quantity cannot be larger than 5")
     var quantity: Int? = null
}