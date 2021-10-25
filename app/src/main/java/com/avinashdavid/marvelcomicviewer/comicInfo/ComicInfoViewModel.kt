package com.avinashdavid.marvelcomicviewer.comicInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avinashdavid.marvelcomicviewer.api.ApiSignature
import com.avinashdavid.marvelcomicviewer.api.marvelApi
import com.avinashdavid.marvelcomicviewer.api.models.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicInfoViewModel : ViewModel() {
    private val _comics = MutableLiveData<Comic?>(null)
    val comics: LiveData<Comic?> get() = _comics

    private var comicId: Int = -1

    fun initiate(comicId: Int) {
        if (comicId != this.comicId) {
            this.comicId = comicId
            val signature = ApiSignature()
            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    val comicDataWrapper = marvelApi.getComicIndividual(apiKey = signature.apiKey, timeStamp = signature.timestamp, hash = signature.hash, comicId = comicId)
                    _comics.postValue(comicDataWrapper?.data?.results?.firstOrNull())
                }
            }
        }
    }
}