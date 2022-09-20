package com.example.stockmarketcomposeapp.domain.repository

import com.example.stockmarketcomposeapp.domain.model.CompanyListing
import com.example.stockmarketcomposeapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListingListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}