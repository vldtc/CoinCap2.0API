package com.example.coincapapi.ui.markets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapi.data.model.markets.MarketsModel
import com.example.coincapapi.data.remote.ApiDetails
import com.example.coincapapi.data.remote.ApiRequest
import com.example.coincapapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketsViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text

    val markets = MutableLiveData<MarketsModel>()

    fun getMarket() {
//        val result = ApiDetails.getInstance(ApiDetails.BASE_URL).create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getMarkets()
            _text.postValue(result.data?.joinToString("\n"))
            markets.postValue(result) // runs when we have the resources
        }

    }
}