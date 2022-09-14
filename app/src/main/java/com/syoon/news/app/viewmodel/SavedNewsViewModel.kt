package com.syoon.news.app.viewmodel

import androidx.lifecycle.*
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.model.News
import com.syoon.news.app.repository.SavedNewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedNewsViewModel(private val savedNewsRepository: SavedNewsRepository): ViewModel()
{

    private val savedNews = MutableLiveData<List<SavedNews>>()

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

    fun fetchSavedList(): LiveData<List<SavedNews>> {
        viewModelScope.launch(Dispatchers.IO) {
            savedNewsRepository.getAllSavedData()
        }
        return savedNews
    }

    fun isSaved(news: SavedNews) {
        viewModelScope.launch(Dispatchers.IO) {
            if (news.isSaved) {
                deleteNews(news)
            } else {
                addNews(news)
            }
        }
    }
}