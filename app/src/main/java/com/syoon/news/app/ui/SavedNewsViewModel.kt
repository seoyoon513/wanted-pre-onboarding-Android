package com.syoon.news.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.news.app.model.SavedNews
import com.syoon.news.app.repository.SavedNewsRepository
import kotlinx.coroutines.launch

class SavedNewsViewModel: ViewModel() {

    private val savedNewsRepository: SavedNewsRepository = TODO()

    private val newsList = MutableLiveData<List<SavedNews>>()

    fun fetchSavedNews(): LiveData<List<SavedNews>> {
        viewModelScope.launch {
            newsList.postValue(savedNewsRepository.getSavedNews())
        }
        return newsList
    }

    fun addNews(news: SavedNews) {
        viewModelScope.launch {
            savedNewsRepository.deleteNews(news)
        }
    }

    fun deleteNews(news: SavedNews) {
        viewModelScope.launch {
            savedNewsRepository.deleteNews(news)
        }
    }
}