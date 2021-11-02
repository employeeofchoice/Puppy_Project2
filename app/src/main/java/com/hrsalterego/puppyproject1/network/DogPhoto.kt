package com.hrsalterego.puppyproject1.network

import com.squareup.moshi.Json
import retrofit2.http.Url

data class DogPhoto (
    @Json(name = "message") val imageUrl: String,
    @Json(name = "status") val statusResponse: String?
        )
