package com.avinashdavid.marvelcomicviewer.comicList

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

class ComicListViewModel: ViewModel() {
    val maxComics = 50

    private val _comics = MutableLiveData<Array<Comic>?>(null)
    val comics: LiveData<Array<Comic>?> get() = _comics

    var currentComicIndex = 0
        set(value) {
            field = when {
                value < 0 -> {
                    0
                }
                value > maxComics - 1 -> {
                    maxComics - 1
                }
                else -> {
                    value
                }
            }
            _comics.postValue(_comics.value)
        }

    fun initiate() {
        val signature = ApiSignature()
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val comicDataWrapper = marvelApi.getComicsCollection(
                    apiKey = signature.apiKey, timeStamp = signature.timestamp, hash = signature.hash,
                    format = "comic", formatType = "comic", noVariants = false, limit = maxComics)
                _comics.postValue(comicDataWrapper?.data?.results)
            }
        }
    }
}