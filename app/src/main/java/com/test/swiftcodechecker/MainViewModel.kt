package com.test.swiftcodechecker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.swiftcodechecker.model.SwiftCodeResponse
import com.test.swiftcodechecker.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<SwiftCodeResponse>> = MutableLiveData()

    fun getSwiftCode(query: String) {
        viewModelScope.launch {
            val response = repository.getSwiftCode(query)
            myResponse.value = response
        }
    }
}