package com.normanaspx.pokeapi.model

import com.google.gson.annotations.SerializedName
import com.normanaspx.pokeapi.utils.Constants


/**
Created by Norman on 12/20/2022
 **/
data class Shows (
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<Show>,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("total_results") val total_results : Int
)
data class Show (

    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("first_air_date") val first_air_date : String,
    @SerializedName("genre_ids") val genre_ids : List<Int>,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("origin_country") val origin_country : List<String>,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_name") val original_name : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("vote_average") val vote_average : Float,
    @SerializedName("vote_count") val vote_count : Int
){
    fun getImageURL() = Constants.IMG_BASE_URL + poster_path
}
