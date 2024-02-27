package com.example.amphibians.data

import com.example.amphibians.network.FrogApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

//Dependency Injection container at the application level
interface AppContainer {
    val frogPhotosRepository : FrogPhotosRepository
}

//Dependency injection container,
//Variables are initizied lazily and the same instance is shared across
//the whole app.
class DefaultAppContainer : AppContainer {
    private val BASE_URL ="https://android-kotlin-fun-mars-server.appspot.com"

    //Retrofit builder to create a retrofit object using kotlin serialization converter
    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    //Retrofit service object for creating api calls
    private val retrofitService: FrogApiService by lazy {
        retrofit.create(FrogApiService::class.java)
    }

    override val frogPhotosRepository: FrogPhotosRepository by lazy {
        NetworkFrogPhotosRepository(retrofitService)
    }
}