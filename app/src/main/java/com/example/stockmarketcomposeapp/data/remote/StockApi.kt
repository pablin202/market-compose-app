package com.example.stockmarketcomposeapp.data.remote

import com.ramcosta.composedestinations.BuildConfig
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListing(
        @Query("apikey") apiKey: String = "478MU3294N86IPZJ"
    ): ResponseBody


    companion object {
        const val BASE_URL = "https://alphavantage.co"
    }
}