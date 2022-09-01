package com.syoon.news.app.ui.topnews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.syoon.news.app.R

class TopNewsFragment: Fragment() {

    val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this).get(TopNewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topNewsViewModel.fetchNewsList().observe(viewLifecycleOwner) {
            Log.d("TopNewsFragment", "items=$it")
        }
    }
}