package com.example.unittesting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unittesting.data.local.ShoppingDao
import com.example.unittesting.data.local.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}