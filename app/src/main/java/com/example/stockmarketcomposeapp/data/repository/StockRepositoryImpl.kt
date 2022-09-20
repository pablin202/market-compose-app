package com.example.stockmarketcomposeapp.data.repository

import com.example.stockmarketcomposeapp.data.csv.CSVParser
import com.example.stockmarketcomposeapp.data.local.StockDatabase
import com.example.stockmarketcomposeapp.data.mapper.toCompanyListing
import com.example.stockmarketcomposeapp.data.mapper.toCompanyListingEntity
import com.example.stockmarketcomposeapp.data.remote.StockApi
import com.example.stockmarketcomposeapp.domain.model.CompanyListing
import com.example.stockmarketcomposeapp.domain.repository.StockRepository
import com.example.stockmarketcomposeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase,
    private val parser: CSVParser<CompanyListing>
) : StockRepository {

    private val dao= db.dao

    override suspend fun getCompanyListingListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListing = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListing.map { it.toCompanyListing() }
            ))
            val isDbEmpty = localListing.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListing = try {
                val response = api.getListing()
                parser.parse(response.byteStream())
            } catch (e:IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e:HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            remoteListing?.let { list ->
                dao.clearCompanyListing()
                dao.insertCompanyListing(list.map { it.toCompanyListingEntity() })
                emit(Resource.Success(
                    data = dao.searchCompanyListing("").map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}