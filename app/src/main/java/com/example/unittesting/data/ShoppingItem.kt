package com.example.unittesting.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String
)