package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.syoon.news.app.databinding.FragmentNewsDetailBinding
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.viewmodel.SavedNewsViewModel

class NewsDetailFragment: BaseFragment<FragmentNewsDetailBinding>(FragmentNewsDetailBinding::inflate) {

    private val savedNewsViewModel: SavedNewsViewModel by lazy {
        ViewModelProvider(this)[SavedNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: NewsDetailFragmentArgs by navArgs()

        binding.toolbarNewsDetail.title = args.news.title
        binding.tvNewsDetailTitle.text = args.news.title
        binding.tvNewsDetailAuthors.text = args.news.author
        binding.tvNewsDetailTime.text = args.news.publishedAt
        binding.tvNewsDetailDescription.text = args.news.content

        Glide.with(this)
            .load(args.news.urlToImage)
            .into(binding.ivNewsDetailImg)

        setNavigation()

        //star image click event
//        binding.ivStar.setOnClickListener(news: News) {
//            val savedNews = SavedNews(
//                author = it.news,
//                title,
//                description,
//                urlToImage,
//                publishedAt,
//                content = it.content
//            )
//
//        }
    }

    private fun setNavigation() {
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}


