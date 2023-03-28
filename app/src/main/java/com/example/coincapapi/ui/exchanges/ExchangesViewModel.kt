package com.example.coincapapi.ui.exchanges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.data.remote.ApiDetails
import com.example.coincapapi.data.remote.ApiRequest
import com.example.coincapapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangesViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text

    val exchanges = MutableLiveData<ExchangesModel>()

    fun getExchanges() {
//        val result = ApiDetails.getInstance(ApiDetails.BASE_URL).create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getExchanges()
            _text.postValue(result.data?.joinToString("\n"))
            exchanges.postValue(result) // runs when we have the resources
        }

    }
}