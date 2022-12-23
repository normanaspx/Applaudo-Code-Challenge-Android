package com.normanaspx.pokeapi.model

import com.google.gson.annotations.SerializedName
import com.normanaspx.pokeapi.utils.Constants


/**
Created by Norman on 12/21/2022
 **/

data class ShowDetail (

     @SerializedName("backdrop_path") val backdrop_path : String,
     @SerializedName("homepage") val homepage : String,
     @SerializedName("id") val id : Int,
     @SerializedName("name") val name : String,
     @SerializedName("number_of_episodes") val number_of_episodes : Int,
     @SerializedName("number_of_seasons") val number_of_seasons : Int,
     @SerializedName("origin_country") val origin_country : List<String>,
     @SerializedName("original_language") val original_language : String,
     @SerializedName("original_name") val original_name : String,
     @SerializedName("overview") val overview : String,
     @SerializedName("popularity") val popularity : Double,
     @SerializedName("poster_path") val poster_path : String,
     @SerializedName("seasons") val seasons : List<Season>,
     @SerializedName("status") val status : String,
     @SerializedName("tagline") val tagline : String,
     @SerializedName("type") val type : String,
     @SerializedName("vote_average") val vote_average : Double,
     @SerializedName("vote_count") val vote_count : Int
){
     fun getImageURL() = Constants.IMG_BASE_URL + poster_path
}
data class Season (
     @SerializedName("air_date") val air_date : String,
     @SerializedName("episode_count") val episode_count : Int,
     @SerializedName("id") val id : Int,
     @SerializedName("name") val name : String,
     @SerializedName("overview") val overview : String,
     @SerializedName("poster_path") val poster_path : String,
     @SerializedName("season_number") val season_number : Int
){
     fun getImageURL() = Constants.IMG_BASE_URL + poster_path

     fun getSeasonNumber() =  season_number + 1
}