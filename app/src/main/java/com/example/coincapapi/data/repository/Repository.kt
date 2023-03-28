package com.example.coincapapi.data.repository

import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.data.model.markets.MarketsModel
import com.example.coincapapi.data.model.rates.RatesModel

interface Repository {

    suspend fun getAssets(): AssetsModel

    suspend fun getAssetsBitcoin(): AssetsModel

    suspend fun getRates(): RatesModel

    suspend fun getExchanges(): ExchangesModel

    suspend fun getMarkets(): MarketsModel
}