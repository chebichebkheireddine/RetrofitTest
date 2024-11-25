package com.example.bookpt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface postIntreface {
    @GET("/Post")
    suspend fun getPost() : Response<Post>
}