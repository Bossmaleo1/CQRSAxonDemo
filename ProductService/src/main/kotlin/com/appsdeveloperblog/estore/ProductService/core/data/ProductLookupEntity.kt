package com.appsdeveloperblog.estore.ProductService.core.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.io.Serializable


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productlookup")
class ProductLookupEntity : Serializable {
    @Id
    private val productId: String? = null

    @Column(unique = true)
    private val title: String? = null

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 2788007460547645663L
    }
}