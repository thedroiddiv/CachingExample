package com.thedroiddiv.cachingsample.data.remote

import com.thedroiddiv.cachingsample.data.models.BeerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int = 20,
    ): List<BeerDto>

    companion object {
        const val baseURL = "https://api.punkapi.com/v2/"
    }
}