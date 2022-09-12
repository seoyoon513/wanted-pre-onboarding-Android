package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.syoon.news.app.databinding.FragmentSavedBinding
import com.syoon.news.app.model.News
import com.syoon.news.app.repository.SavedNewsRepository
import com.syoon.news.app.ui.adapter.TopNewsAdapter
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.ui.common.ViewModelFactory
import com.syoon.news.app.viewmodel.SavedNewsViewModel
import com.syoon.news.app.viewmodel.TopNewsViewModel

class SavedFragment: BaseFragment<FragmentSavedBinding>(FragmentSavedBinding::inflate) {

    private val savedNewsViewModel: SavedNewsViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(SavedNewsRepository(requireContext())))[SavedNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListAdapter()
    }

    private fun setListAdapter() {
        val topNewsAdapter = TopNewsAdapter()
        binding.rvSavedNews.adapter = topNewsAdapter
        savedNewsViewModel.fetchSavedList().observe(viewLifecycleOwner) { saved ->
//            val savedNewsList = mutableListOf<News>()
//
//            for(i in saved.toMutableList()) {
//                var news = News(
//                    i.author,
//                    i.title,
//                    i.urlToImage,
//                    i.publishedAt,
//                    i.content)
//
//                savedNewsList.add(news)
//            }

            topNewsAdapter.submitList(saved)
        }
    }

}