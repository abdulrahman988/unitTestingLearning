package com.example.unittesting.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unittesting.data.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}