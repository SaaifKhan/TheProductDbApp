package com.saif.truckitin.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductModel")
data class ProductModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
    var isAddToCard: Boolean = false
)