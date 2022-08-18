package com.example.apiapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiapp.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val dataResponse = MutableLiveData<List<DataResponseItem>>()

    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()


    fun getCatPicture(
        responseHandlerCat: (List<DataResponseItem>) -> Unit,
        error: (Throwable) -> Unit
    ) {

        ApiClient.getApiService().getTheCat().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                responseHandlerCat(it)
            }, {
                error(it)
            })
    }


    fun getDataCat() {
        isLoading.value = true
        getCatPicture({
            isLoading.value = false
            dataResponse.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}