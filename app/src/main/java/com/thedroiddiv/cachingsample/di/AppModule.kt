package com.thedroiddiv.cachingsample.di

import android.content.Context
import android.graphics.pdf.PdfDocument.Page
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thedroiddiv.cachingsample.data.local.BeerDao
import com.thedroiddiv.cachingsample.data.local.BeerDb
import com.thedroiddiv.cachingsample.data.local.BeerEntity
import com.thedroiddiv.cachingsample.data.remote.BeerApi
import com.thedroiddiv.cachingsample.data.remote.BeerRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerDb(@ApplicationContext context: Context): BeerDb {
        return Room.databaseBuilder(context, BeerDb::class.java, "beer.db").build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }


    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beerDb: BeerDb, beerApi: BeerApi): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(20),
            remoteMediator = BeerRemoteMediator(beerApi, beerDb),
            pagingSourceFactory = {
                beerDb.dao.pagingSource()
            }
        )
    }
}