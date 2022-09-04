package com.syoon.news.app.ui.newsdetail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentNewsDetailBinding
import com.syoon.news.app.ui.common.BaseFragment

class NewsDetailFragment: BaseFragment<FragmentNewsDetailBinding>(FragmentNewsDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsTitle = requireArguments().getString("title")
        val newsAuthor = requireArguments().getString("author")
        val newsTime = requireArguments().getString("publishedAt")
        val newsContent = requireArguments().getString("content")
        val newsImage = requireArguments().getString("urlToImage")

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

        }
    }

    private fun setNavigation() {
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}


