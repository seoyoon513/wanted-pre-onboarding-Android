package com.syoon.news.app.ui.topnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syoon.news.app.databinding.ItemTopNewsBinding
import com.syoon.news.app.model.TopNewsDto


class TopNewsAdapter: ListAdapter<TopNewsDto, TopNewsAdapter.TopNewsViewHolder>(
    TopNewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        val binding = ItemTopNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopNewsViewHolder(private val binding: ItemTopNewsBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(topnews: TopNewsDto) {
                binding.topnews = topnews.articles.get(3)
                binding.executePendingBindings()
            }
        }

}

class TopNewsDiffCallback: DiffUtil.ItemCallback<TopNewsDto>() {
    override fun areItemsTheSame(oldItem: TopNewsDto, newItem: TopNewsDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TopNewsDto, newItem: TopNewsDto): Boolean {
        return oldItem == newItem
    }

}