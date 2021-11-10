package com.saif.truckitin

import com.saif.truckitin.data.models.ProductModel

/**
 * @author AliAzazAlam on 5/26/2021.
 */
class MockTestUtil {
    companion object {
        fun createZeroProductModel(): ProductModel {
            return ProductModel(
                id = 0,
                title = "",
                price = "",
                category = "",
                description = "",
                image = "",
                isAddToCard = false

            )
        }

        fun createZeroProductList(): ArrayList<ProductModel> {
            val list = ArrayList<ProductModel>()
            list.add(ProductModel(0,"","","","","",isAddToCard = false))
            return  list
        }

        fun createProduct(): ProductModel {
            return ProductModel(
                id = 1,
                title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                price = "109.95",
                category = "men's clothing",
                description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                isAddToCard = true
            )
        }

        fun createSingleProductResponse() = createProductResponse()[0]

        fun createProductResponse() = listOf(
            ProductModel(
                id = 1,
                title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                price = "109.95",
                category = "men's clothing",
                description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                isAddToCard = true
            )
        )

    }
}