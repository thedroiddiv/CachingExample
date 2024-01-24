package com.thedroiddiv.cachingsample.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(beerEntities: List<BeerEntity>)

    @Query("SELECT * FROM beer_record")
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM beer_record")
    suspend fun clearAll()
}