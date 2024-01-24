package com.thedroiddiv.cachingsample.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.map
import com.thedroiddiv.cachingsample.data.local.BeerEntity
import com.thedroiddiv.cachingsample.data.mapper.toBeer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerVM
@Inject
constructor(
    pager: Pager<Int, BeerEntity>
) : ViewModel() {

    val beerPagingFlow = pager.flow.map {pagingData ->
        pagingData.map { it.toBeer() }
    }
}