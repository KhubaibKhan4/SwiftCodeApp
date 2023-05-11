package com.test.swiftcodechecker.repository

import com.test.swiftcodechecker.api.RetrofitInstance
import com.test.swiftcodechecker.model.SwiftCodeResponse
import retrofit2.Response

class Repository {
    suspend fun getSwiftCode(query: String): Response<SwiftCodeResponse>{
        return RetrofitInstance.api.getSwiftCode(query)
    }
}