package com.test.swiftcodechecker.model

data class SwiftCodeResponseItem(
    val bank_name: String,
    val branch: String,
    val city: String,
    val country: String,
    val country_code: String,
    val swift_code: String
)