package com.avinashdavid.marvelcomicviewer.comicInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avinashdavid.marvelcomicviewer.api.models.Comic
import com.avinashdavid.marvelcomicviewer.util.ApiSignature
import com.avinashdavid.marvelcomicviewer.util.marvelApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicInfoViewModel : ViewModel() {
    private val _comic = MutableLiveData<Comic?>(null)
    val comic: LiveData<Comic?> get() = _comic

    private var comicId: Int = -1

    fun initiate(comicId: Int) {
        if (comicId != this.comicId) {
            this.comicId = comicId
            val signature = ApiSignature()
            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    val comicDataWrapper = marvelApi.getComicIndividual(apiKey = signature.apiKey, timeStamp = signature.timestamp, hash = signature.hash, comicId = comicId)
                    _comic.postValue(comicDataWrapper?.data?.results?.firstOrNull())
                }
            }
        }
    }
}