package com.syoon.news.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.news.app.database.AppDataBase
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.repository.SavedNewsRepository
import kotlinx.coroutines.launch

class SavedNewsViewModel: ViewModel() {

    private val savedNewsRepository = SavedNewsRepository()
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