package com.syoon.news.app.ui.categorynews

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentCategoryNewsBinding
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.ui.common.EventObserver
import com.syoon.news.app.ui.topnews.TopNewsAdapter
import com.syoon.news.app.ui.topnews.TopNewsViewModel

class CategoryNewsFragment :
    BaseFragment<FragmentCategoryNewsBinding>(FragmentCategoryNewsBinding::inflate) {

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this)[TopNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = requireArguments().getString("category")
        binding.toolbarCategoryNews.title = "Category - $category"

        setListAdapter(category.toString())

        topNewsViewModel.openNewsDetailEvent.observe(viewLifecycleOwner, EventObserver {
            openNewsDetail(it.title, it.author, it.publishedAt, it.content, it.urlToImage)
        })

        setNavigation()
    }

    private fun setListAdapter(category: String) {
        val topNewsAdapter = TopNewsAdapter(topNewsViewModel)
        binding.rvCategoryNews.adapter = topNewsAdapter
        topNewsViewModel.fetchCategoryNews(category).observe(viewLifecycleOwner) { news ->
            topNewsAdapter.submitList(news)
        }
    }

    private fun openNewsDetail(
        title: String, author: String, publishedAt: String, content: String, urlToImage: String
    ) {
        findNavController().navigate(
            R.id.action_navigation_category_news_to_navigation_news_detail, bundleOf(
                "title" to title,
                "author" to author,
                "publishedAt" to publishedAt,
                "content" to content,
                "urlToImage" to urlToImage
            )
        )
    }

    private fun setNavigation() {
        binding.toolbarCategoryNews.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}