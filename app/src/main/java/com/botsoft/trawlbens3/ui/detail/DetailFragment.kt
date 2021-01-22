package com.botsoft.trawlbens3.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.botsoft.trawlbens3.R
import com.botsoft.trawlbens3.databinding.FragmentListBinding
import com.botsoft.trawlbens3.di.extension.loadCircleFromUrl
import com.botsoft.trawlbens3.ui.BaseFragment
import com.botsoft.trawlbens3.ui.list.ListViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : BaseFragment() {
    val arg: DetailFragmentArgs by navArgs()
    val viewModel: DetailViewModel? by viewModels{ viewModelFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.getGamesById(arg.gameId)?.observe(viewLifecycleOwner){
            txt_name.text = it.name
            txt_desc.text = it.description_raw
            Glide.with(this).load(it.background_image).circleCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(img_game)
        }
    }

}