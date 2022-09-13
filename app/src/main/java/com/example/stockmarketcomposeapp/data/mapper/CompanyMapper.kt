package com.example.stockmarketcomposeapp.data.mapper

import com.example.stockmarketcomposeapp.data.local.CompanyListingEntity
import com.example.stockmarketcomposeapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        symbol, name, exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        symbol, name, exchange
    )
}