package com.test.swiftcodechecker.api

import com.test.swiftcodechecker.model.SwiftCodeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface SwiftCodeApi {
    @Headers("X-Api-Key: Your API KEY")
    @GET("swiftcode")
    suspend fun getSwiftCode(
        @Query("bank") query: String
    ): Response<SwiftCodeResponse>
}