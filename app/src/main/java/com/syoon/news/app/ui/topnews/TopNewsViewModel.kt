package com.syoon.news.app.ui.topnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.news.app.model.TopNewsDto
import com.syoon.news.app.repository.TopNewsRepository
import com.syoon.news.app.common.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class TopNewsViewModel: ViewModel() {

    private val topNewsRepository = TopNewsRepository()

    private val _items = MutableLiveData<TopNewsDto>()

    fun fetchNewsList(): LiveData<TopNewsDto> {
        viewModelScope.launch {
            _items.postValue(topNewsRepository.getTopNews(API_KEY))
        }
        return _items
    }
}