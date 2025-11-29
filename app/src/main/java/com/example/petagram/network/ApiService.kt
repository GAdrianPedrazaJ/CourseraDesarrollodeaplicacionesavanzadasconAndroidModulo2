package com.example.petagram.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // Endpoint de ejemplo de prueba (JSONPlaceholder)
    @GET("posts/1")
    fun getPost(): Call<PostResponse>

    // Para obtener todos los posts
    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>

    // Este era el que ya tenías para Instagram
    @GET("me/media")
    fun getRecentMedia(
        @Query("access_token") accessToken: String
    ): Call<InstagramResponse>
}