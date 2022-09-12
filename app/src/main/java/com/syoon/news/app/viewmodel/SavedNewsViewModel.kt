package com.syoon.news.app.viewmodel

import androidx.lifecycle.*
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.model.News
import com.syoon.news.app.repository.SavedNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedNewsViewModel(private val savedNewsRepository: SavedNewsRepository): ViewModel()
{

    private val newsList = MutableLiveData<List<News>>()

    fun addNews(news: SavedNews) {
        viewModelScope.launch(Dispatchers.IO) {
            savedNewsRepository.addNews(news)
        }
    }

    fun deleteNews(news: SavedNews) {
        viewModelScope.launch(Dispatchers.IO) {
            savedNewsRepository.deleteNews(news)
        }
    }

    fun fetchSavedList(): LiveData<List<News>> {
        viewModelScope.launch(Dispatchers.IO) {
            savedNewsRepository.getAllSavedData()
        }
        return newsList
    }
}