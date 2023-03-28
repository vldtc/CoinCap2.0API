package com.example.coincapapi.data.repository

import com.example.coincapapi.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
) : Repository {

    override suspend fun getAssets() = apiRequest.getAssets()

    override suspend fun getAssetsBitcoin() = apiRequest.getAssetsBitcoin()

    override suspend fun getRates() = apiRequest.getRates()

    override suspend fun getExchanges() = apiRequest.getExchanges()

    override suspend fun getMarkets() = apiRequest.getMarkets()
}