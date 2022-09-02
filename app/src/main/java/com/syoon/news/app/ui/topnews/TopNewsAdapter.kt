package com.syoon.news.app.ui.topnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syoon.news.app.databinding.ItemTopNewsBinding
import com.syoon.news.app.model.News
import com.syoon.news.app.model.TopNewsDto


class TopNewsAdapter(private val viewModel: TopNewsViewModel) :
    ListAdapter<News, TopNewsAdapter.TopNewsViewHolder>(
        TopNewsDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        val binding = ItemTopNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TopNewsViewHolder(private val binding: ItemTopNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.viewModel = viewModel
            binding.topnews = news
            binding.executePendingBindings()

        }
    }
}

class TopNewsDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}