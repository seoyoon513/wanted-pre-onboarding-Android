package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.databinding.FragmentNewsDetailBinding
import com.syoon.news.app.repository.SavedNewsRepository
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.ui.common.ViewModelFactory
import com.syoon.news.app.viewmodel.SavedNewsViewModel

class NewsDetailFragment: BaseFragment<FragmentNewsDetailBinding>(FragmentNewsDetailBinding::inflate) {

    private val savedNewsViewModel: SavedNewsViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(SavedNewsRepository(requireContext())))[SavedNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: NewsDetailFragmentArgs by navArgs()

        val newsTitle = args.news.title
        val newsAuthor = args.news.author
        val newsTime = args.news.publishedAt
        val newsContent = args.news.content
        val newsImage = args.news.urlToImage



        binding.toolbarNewsDetail.title = newsTitle
        binding.tvNewsDetailTitle.text = newsTitle
        binding.tvNewsDetailAuthors.text = newsAuthor
        binding.tvNewsDetailTime.text = newsTime
        binding.tvNewsDetailDescription.text = newsContent

        Glide.with(this)
            .load(newsImage)
            .into(binding.ivNewsDetailImg)

        setNavigation()

        //star image click event
        binding.ivStar.setOnClickListener {
            val saved = SavedNews(
                newsTitle.toString(),
                newsAuthor.toString(),
                newsImage.toString(),
                newsTime.toString(),
                newsContent.toString(),
                false
            )

            it.isSelected = !it.isSelected
            savedNewsViewModel.addNews(saved)


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


