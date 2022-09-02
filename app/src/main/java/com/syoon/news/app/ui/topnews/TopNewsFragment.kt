package com.syoon.news.app.ui.topnews

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentTopNewsBinding
import com.syoon.news.app.model.News
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.ui.common.EventObserver

class TopNewsFragment: BaseFragment<FragmentTopNewsBinding>(FragmentTopNewsBinding::inflate) {

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this)[TopNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListAdapter()

        topNewsViewModel.openNewsDetailEvent.observe(viewLifecycleOwner, EventObserver {
            openNewsDetail(it.title, it.author, it.publishedAt, it.content, it.urlToImage)
        })
    }

    private fun setListAdapter() {
        val topNewsAdapter = TopNewsAdapter(topNewsViewModel)
        binding.rvTopNews.adapter = topNewsAdapter
        topNewsViewModel.fetchNewsList().observe(viewLifecycleOwner) { news ->
            topNewsAdapter.submitList(news)
        }
    }

    private fun openNewsDetail(
        title: String, author: String, publishedAt: String, content: String, urlToImage: String
    ) {
        findNavController().navigate(R.id.action_navigation_top_news_to_news_detail, bundleOf(
            "title" to title,
            "author" to author,
            "publishedAt" to publishedAt,
            "content" to content,
            "urlToImage" to urlToImage
        ))
    }
}