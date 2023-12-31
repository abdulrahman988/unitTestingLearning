package com.example.unittesting.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String
)