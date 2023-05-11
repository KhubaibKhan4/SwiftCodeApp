package com.test.swiftcodechecker.api

import com.test.swiftcodechecker.util.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SwiftCodeApi by lazy {
        retrofit.create(SwiftCodeApi::class.java)
    }
}