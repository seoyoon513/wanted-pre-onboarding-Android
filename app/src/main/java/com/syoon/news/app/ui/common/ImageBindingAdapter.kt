package com.syoon.news.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.syoon.news.app.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if(!imageUrl.isNullOrEmpty()) {
        Glide.with(view)
            .load(imageUrl)
            .into(view)
    }
}