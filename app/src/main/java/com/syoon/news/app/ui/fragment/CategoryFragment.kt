package com.syoon.news.app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.syoon.news.app.R
import com.syoon.news.app.databinding.FragmentCategoryBinding
import com.syoon.news.app.ui.common.BaseFragment

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryBusiness.setOnClickListener {
            openNewsList("business")
        }

        binding.btnCategoryEntertainment.setOnClickListener {
            openNewsList("entertainment")
        }

        binding.btnCategoryGeneral.setOnClickListener {
            openNewsList("general")
        }

        binding.btnCategoryHealth.setOnClickListener {
            openNewsList("health")
        }

        binding.btnCategoryScience.setOnClickListener {
            openNewsList("science")
        }

        binding.btnCategorySport.setOnClickListener {
            openNewsList("sports")
        }

        binding.btnCategoryTechnology.setOnClickListener {
            openNewsList("technology")
        }
    }

    private fun openNewsList(category: String) {
        findNavController().navigate(
            R.id.action_navigation_categories_to_categoryNewsFragment, bundleOf(
                "category" to category
            )
        )
    }
}
