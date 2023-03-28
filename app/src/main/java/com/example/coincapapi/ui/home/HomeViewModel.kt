package com.example.coincapapi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.remote.ApiRequest
import com.example.coincapapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Stock Previewer!"
    }
    val text: LiveData<String> = _text

    val home = MutableLiveData<AssetsModel>()

    fun getAssetsBitcoin() {
//        val result = ApiDetails.getInstance(ApiDetails.BASE_URL).create(ApiRequest::class.java)

        viewModelScope.launch {
            val result = repository.getAssetsBitcoin()
            _text.postValue(result.data?.joinToString("\n"))
            home.postValue(result) // runs when we have the resources
        }

    }
}