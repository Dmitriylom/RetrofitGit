package com.example.retrofit1.Interface

import com.example.retrofit1.Model.Movie
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}