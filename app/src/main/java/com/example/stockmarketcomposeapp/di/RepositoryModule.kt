package com.example.stockmarketcomposeapp.di

import com.example.stockmarketcomposeapp.data.csv.CSVParser
import com.example.stockmarketcomposeapp.data.csv.CompanyListingParser
import com.example.stockmarketcomposeapp.data.csv.IntradayInfoParser
import com.example.stockmarketcomposeapp.data.repository.StockRepositoryImpl
import com.example.stockmarketcomposeapp.domain.model.CompanyListing
import com.example.stockmarketcomposeapp.domain.model.IntradayInfo
import com.example.stockmarketcomposeapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}