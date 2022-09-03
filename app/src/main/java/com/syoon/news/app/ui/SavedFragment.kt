package com.syoon.news.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentCategoryNewsBinding
import com.syoon.news.app.databinding.FragmentSavedBinding
import com.syoon.news.app.ui.common.BaseFragment

class SavedFragment: BaseFragment<FragmentSavedBinding>(FragmentSavedBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}