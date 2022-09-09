package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.syoon.news.app.databinding.FragmentSavedBinding
import com.syoon.news.app.ui.common.BaseFragment
import com.syoon.news.app.viewmodel.SavedNewsViewModel

class SavedFragment: BaseFragment<FragmentSavedBinding>(FragmentSavedBinding::inflate) {

    private val savedNewsViewModel: SavedNewsViewModel by lazy {
        ViewModelProvider(this)[SavedNewsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}