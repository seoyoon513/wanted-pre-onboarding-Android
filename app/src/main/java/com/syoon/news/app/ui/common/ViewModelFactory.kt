package com.syoon.news.app.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syoon.news.app.repository.SavedNewsRepository
import com.syoon.news.app.viewmodel.SavedNewsViewModel

class ViewModelFactory(private val repository: SavedNewsRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SavedNewsViewModel::class.java)) {
            return SavedNewsViewModel(this.repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}