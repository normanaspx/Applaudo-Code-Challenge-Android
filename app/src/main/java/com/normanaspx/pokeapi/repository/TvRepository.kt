package com.normanaspx.pokeapi.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.normanaspx.pokeapi.utils.Response
import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.model.ShowDetail
import com.normanaspx.pokeapi.network.MovieDBAPI
import com.normanaspx.pokeapi.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
Created by Norman on 12/20/2022
 **/
class TvRepository @Inject constructor(private val service: MovieDBAPI)  {

    fun getShowsFromNetwork(type: String): Flow<PagingData<Show>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = true
        ),
        pagingSourceFactory =  { TVPagingSource(service, type)}
    ).flow

    fun getShowDetailFromNetwork(id: Int): Flow<Response<ShowDetail>> = flow{
        try {
            emit(Response.Loading)
            val responseApi = service.getTVDetail(id, Constants.api)
            emit(Response.Success(responseApi))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)
}