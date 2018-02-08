package com.example.mytemplateapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by Administrator on 2018/2/7.
 */
interface api {
    @GET
    fun getData(@Url url: String, @Query("key") bookshelves: String):Call<String>
}