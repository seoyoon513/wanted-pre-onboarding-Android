package com.syoon.news.app.ui.topnews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.syoon.news.app.R
import com.syoon.news.app.common.BaseFragment
import com.syoon.news.app.databinding.FragmentTopNewsBinding

class TopNewsFragment: BaseFragment<FragmentTopNewsBinding>(FragmentTopNewsBinding::inflate) {

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this).get(TopNewsViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListAdapter()
//        topNewsViewModel.fetchNewsList().observe(viewLifecycleOwner) {
//            Log.d("TopNewsFragment", "items=$it")
//        }

    }

    private fun setListAdapter() {
        val topNewsAdapter = TopNewsAdapter()
        binding.rvTopNews.adapter = topNewsAdapter
        topNewsViewModel.fetchNewsList().observe(viewLifecycleOwner) { topNews ->
            topNewsAdapter.submitList(listOf(topNews))
        }
    }
}