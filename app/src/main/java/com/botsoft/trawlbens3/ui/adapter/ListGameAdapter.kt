package com.botsoft.trawlbens3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.botsoft.trawlbens3.R
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.databinding.ItemGameBinding
import com.botsoft.trawlbens3.ui.adapter.ListGameAdapter.ViewHolder.Companion.from

class ListGameAdapter() : ListAdapter<Game, ListGameAdapter.ViewHolder>(GameDiffCallback()) {

    object ResUtil{
        const val DEFAULT_Game_ERROR = R.drawable.ic_placeholder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder private constructor(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            binding.game = game
//            binding.gameVm = gameVm
            binding.resUtil = ResUtil
//            binding.ivGame.transitionName = user.id
//            binding.cvGame.setOnClickListener { clickListener.onClick(user, binding.ivGame) }
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup) = ViewHolder(
                ItemGameBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}

class GameDiffCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Game, newItem: Game) =
        oldItem == newItem
}

class GameListener(val clickListener: (user: Game, imageView: ImageView) -> Unit) {
    fun onClick(user: Game, imageView: ImageView) = clickListener(user, imageView)
}