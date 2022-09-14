package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.syoon.news.app.R
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.databinding.FragmentNewsDetailBinding
import com.syoon.news.app.repository.SavedNewsRepository
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.ui.common.ViewModelFactory
import com.syoon.news.app.viewmodel.SavedNewsViewModel
import com.syoon.news.app.viewmodel.TopNewsViewModel

class NewsDetailFragment: BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {

    private val topNewsViewModel: TopNewsViewModel by lazy {
        ViewModelProvider(this)[TopNewsViewModel::class.java]
    }

    private val savedNewsViewModel: SavedNewsViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(SavedNewsRepository(requireContext())))[SavedNewsViewModel::class.java]
    }

    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = args.news

        setNavigation()
        binding.news = news

        //star image click event
        binding.ivStar.setOnClickListener {
            val saved = SavedNews(
                news.title.toString(),
                news.author.toString(),
                news.urlToImage.toString(),
                news.publishedAt.toString(),
                news.content.toString(),
                false
            )

            if(!saved.isSaved) {
                it.isSelected = !it.isSelected
                savedNewsViewModel.addNews(saved)
                saved.isSaved = true

            } else {
                it.isSelected = !it.isSelected
                savedNewsViewModel.deleteNews(saved)
                saved.isSaved = false
            }

        }
    }


    private fun setNavigation() {
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}


