package com.example.unittesting.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unittesting.data.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM SHOPPING_TABLE")
    fun getAllShoppingItem():Flow<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount) From shopping_table")
    fun getTotalPrice():Flow<Float>

}