package com.normanaspx.pokeapi.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.model.Shows
import com.normanaspx.pokeapi.network.MovieDBAPI
import com.normanaspx.pokeapi.utils.Constants
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.io.IOException

/**
Created by Norman on 12/20/2022
 **/
class TVPagingSource (
    private val service: MovieDBAPI,
    val type: String
): PagingSource<Int, Show>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Show > {
        val position = params.key ?: 1
        return try {
            val response = setMethod(type = type, service = service, position = position)
            LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.results.isEmpty()) null else position + 1
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch (exception: HttpException){
            return LoadResult.Error(exception)
        }catch (exception: JsonDataException){
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Show>): Int? {
        return state.anchorPosition
    }

   suspend fun setMethod(type: String, service: MovieDBAPI, position: Int): Shows {
       return when(type){
           "popular" -> service.getPopularShows(Constants.api, position)
           "mostrated" -> service.getTopRated(Constants.api, position)
           else -> service.getPopularShows(Constants.api, position)
       }
   }


}