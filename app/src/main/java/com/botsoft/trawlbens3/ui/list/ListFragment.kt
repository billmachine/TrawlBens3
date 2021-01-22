package com.botsoft.trawlbens3.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.databinding.FragmentListBinding
import com.botsoft.trawlbens3.ui.BaseFragment
import com.botsoft.trawlbens3.ui.adapter.ListGameAdapter
import com.botsoft.trawlbens3.ui.detail.DetailFragmentArgs

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
        val adapter = ListGameAdapter()
        binding.rvGame.adapter = adapter
        adapter.listener = object : ListGameAdapter.OnItemClickListener {
            override fun onItemClick(game: Game) {
                val extras = FragmentNavigatorExtras()
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(game.id!!)
                findNavController().navigate(action, extras)
            }
        }

        return binding.root
    }

}