package com.example.unittesting.data.remote

import com.example.unittesting.data.remote.respones.ImageResponse
import com.example.unittesting.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiInterface {

    @GET("/api/")
    suspend fun getImage(
        @Query("q") search: String,
        @Query("key") apiKey: String = Constants.API_KEY
    ): Response<ImageResponse>

}