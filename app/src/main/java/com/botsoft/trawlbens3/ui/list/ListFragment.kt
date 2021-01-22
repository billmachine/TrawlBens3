package com.botsoft.trawlbens3.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.botsoft.trawlbens3.R
import com.botsoft.trawlbens3.databinding.FragmentListBinding
import com.botsoft.trawlbens3.ui.BaseFragment
import com.botsoft.trawlbens3.ui.adapter.ListGameAdapter

class ListFragment : BaseFragment() {
    val viewModel: ListViewModel? by viewModels{ viewModelFactory}
    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.listVM = viewModel
        binding.rvGame.apply {
            postponeEnterTransition()
            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }
        binding.rvGame.adapter = ListGameAdapter(
//            UserListener { user, imageView ->
//            val extras = FragmentNavigatorExtras(imageView to user.id)
//            val action = UserListFragmentDirections.actionUserDetail(user, imageView.transitionName)
//            findNavController().navigate(action, extras)
//        },userViewModel
        )
        return binding.root
    }

}