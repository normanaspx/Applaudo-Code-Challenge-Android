package com.normanaspx.pokeapi.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.normanaspx.pokeapi.utils.Response
import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.model.ShowDetail
import com.normanaspx.pokeapi.repository.TvRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
Created by Norman on 12/21/2022
 **/

@HiltViewModel
class SharedViewModel @Inject constructor(val repository: TvRepository) : ViewModel() {

     val showList: Flow<PagingData<Show>> =
          repository.getShowsFromNetwork("").cachedIn(viewModelScope)

     fun showList(type: String): Flow<PagingData<Show>> = repository.getShowsFromNetwork(type).cachedIn(viewModelScope)


     private val _detailState = mutableStateOf<Response<ShowDetail>>(Response.Success(null))
     val detailState: State<Response<ShowDetail>> = _detailState

     fun getShowDetail(id: Int) {
          viewModelScope.launch {
               repository.getShowDetailFromNetwork(id).collect { response ->
                    _detailState.value = response
               }
          }
     }

}