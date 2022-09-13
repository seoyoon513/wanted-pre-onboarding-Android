package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentTopNewsBinding
import com.syoon.news.app.ui.adapter.TopNewsAdapter
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.viewmodel.TopNewsViewModel

class TopNewsFragment : BaseFragment<FragmentTopNewsBinding>(R.layout.fragment_top_news){

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this)[TopNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListAdapter()

    }

    private fun setListAdapter() {
        val topNewsAdapter = TopNewsAdapter()
        binding.rvTopNews.adapter = topNewsAdapter
        topNewsViewModel.fetchNewsList().observe(viewLifecycleOwner) { news ->
            topNewsAdapter.submitList(news)
        }
    }
}