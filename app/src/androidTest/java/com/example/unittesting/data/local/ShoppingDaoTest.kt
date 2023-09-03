package com.example.unittesting.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

//    @get: Rule
//    val dispatcherRule = TestDispatcherRule()

    private lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingItemDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.shoppingDao()
    }

    @After
    fun teardown() {
        database.close()
    }


    @Test
    fun insertShoppingItem() {
        runTest {
            val shoppingItem = ShoppingItem(1, "name", 1, 1f, "url")
            dao.insertShoppingItem(shoppingItem)

            dao.getAllShoppingItem().test {
                val list = awaitItem()
                assert(list.contains(shoppingItem))
            }

        }
    }

    @Test
    fun deleteShoppingItem() {
        runTest {
            val shoppingItem = ShoppingItem(1, "name", 1, 1f, "url")
            dao.insertShoppingItem(shoppingItem)

            dao.deleteShoppingItem(shoppingItem)
            dao.getAllShoppingItem().test {
                val list = awaitItem()
                assert(!list.contains(shoppingItem))
            }

        }
    }

    @Test
    fun getTotalPriceSum() {
        runTest {
            val shoppingItem1 = ShoppingItem(1, "name1", 1, 1f, "url1")
            val shoppingItem2 = ShoppingItem(2, "name2", 2, 2f, "url2")
            val shoppingItem3 = ShoppingItem(3, "name3", 3, 3f, "url3")
            dao.insertShoppingItem(shoppingItem1)
            dao.insertShoppingItem(shoppingItem2)
            dao.insertShoppingItem(shoppingItem3)

            dao.getTotalPrice().test {
                val totalPrice = awaitItem()
                assert(totalPrice.equals(shoppingItem1.price * shoppingItem1.amount + shoppingItem2.price * shoppingItem2.amount + shoppingItem3.price * shoppingItem3.amount))
            }

        }
    }
}