package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.syoon.news.app.R
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.databinding.FragmentNewsDetailBinding
import com.syoon.news.app.model.News
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


        setNavigation()
        binding.news = args.news

        //star image click event
        binding.ivStar.setOnClickListener {
//            val saved = SavedNews(
//                newsTitle.toString(),
//                newsAuthor.toString(),
//                newsImage.toString(),
//                newsTime.toString(),
//                newsContent.toString(),
//                false
//            )
//
//            it.isSelected = !it.isSelected
//            savedNewsViewModel.addNews(saved)


//            if(!saved.isSavedNews) {
//                saved.isSavedNews = true
//                it.isSelected = !it.isSelected
//                savedNewsViewModel.addNews(saved)
//
//            } else {
//                saved.isSavedNews = false
//                it.isSelected = !it.isSelected
//                savedNewsViewModel.deleteNews(saved)
//            }

        }
    }

    private fun setNavigation() {
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}


