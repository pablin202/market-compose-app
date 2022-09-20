package com.example.stockmarketcomposeapp.presentation.company_listings

import com.example.stockmarketcomposeapp.domain.model.CompanyListing

data class CompanyListingState(
    val companies : List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val query: String = ""
)
