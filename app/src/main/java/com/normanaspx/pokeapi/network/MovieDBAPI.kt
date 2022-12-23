package com.normanaspx.pokeapi.network

import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.model.ShowDetail
import com.normanaspx.pokeapi.model.Shows
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBAPI {
    @GET("tv/popular")
    suspend fun getPopularShows(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Shows

    @GET("tv/top_rated")
    suspend fun getTopRated(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Shows

    @GET("tv/on_the_air")
    suspend fun getOnTV(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Shows

    @GET("tv/{tv_id}")
    suspend fun getTVDetail(
        @Path("tv_id") tv_id: Int,
        @Query("api_key") api_key: String
    ): ShowDetail
}