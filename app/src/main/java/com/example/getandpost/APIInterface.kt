package com.example.getandpost
import retrofit2.Call
import retrofit2.http.*



interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/custom-people/")
    fun getUser(): Call<List<People.PeopleItem>>

    @Headers("Content-Type: application/json")
    @POST("/custom-people/")
    fun addUser(@Body userData: People.PeopleItem): Call<People.PeopleItem>

}