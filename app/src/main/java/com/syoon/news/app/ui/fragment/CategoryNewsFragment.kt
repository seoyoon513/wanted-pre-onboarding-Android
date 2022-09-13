package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentCategoryNewsBinding
import com.syoon.news.app.model.News
import com.syoon.news.app.ui.adapter.TopNewsAdapter
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.viewmodel.TopNewsViewModel

class CategoryNewsFragment :
    BaseFragment<FragmentCategoryNewsBinding>(R.layout.fragment_category_news) {

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this)[TopNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = requireArguments().getString("category")
        val upperCharacter = category?.substring(0, 1)?.uppercase()
        val categoryTitle = upperCharacter + category?.substring(1, category.length)
        binding.toolbarCategoryNews.title = "Category - $categoryTitle"

        setListAdapter(category.toString())
        setNavigation()
    }

    private fun setListAdapter(category: String) {
        val topNewsAdapter = TopNewsAdapter()
        binding.rvCategoryNews.adapter = topNewsAdapter
        topNewsViewModel.fetchCategoryNews(category).observe(viewLifecycleOwner) { news ->
            topNewsAdapter.submitList(news)
        }
    }

    private fun setNavigation() {
        binding.toolbarCategoryNews.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}