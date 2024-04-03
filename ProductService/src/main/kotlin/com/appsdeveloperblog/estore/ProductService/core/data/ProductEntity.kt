package com.appsdeveloperblog.estore.ProductService.core.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import java.io.Serializable
import java.math.BigDecimal

@Entity
@Table(name = "products")
@Data
class ProductEntity : Serializable {
    @Id
    @Column(unique = true)
    var productId: String? = null

    @Column(unique = true)
     var title: String? = null
     var price: BigDecimal? = null
     var quantity: Int? = null

    companion object {
        /**
         *
         */
        private const val serialVersionUID = -227264951080660124L
    }
}