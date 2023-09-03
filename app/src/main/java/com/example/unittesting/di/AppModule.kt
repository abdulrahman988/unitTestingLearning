package com.example.unittesting.di

import android.content.Context
import androidx.room.Room
import com.example.unittesting.data.local.ShoppingItemDatabase
import com.example.unittesting.data.remote.PixabayApiInterface
import com.example.unittesting.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        ShoppingItemDatabase::class.java,
        Constants.DATABASE_NAME
    )


    @Provides
    @Singleton
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Provides
    @Singleton
    fun providePixabayAPI(): PixabayApiInterface = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL).build().create(PixabayApiInterface::class.java)
}