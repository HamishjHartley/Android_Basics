package com.example.amphibians.network

import com.example.amphibians.model.FrogPhoto
import retrofit2.http.GET

//Public interface which exposes the getPhotos() method
interface FrogApiService {
    @GET("photos")
    suspend fun getPhotos(): List<FrogPhoto>
}