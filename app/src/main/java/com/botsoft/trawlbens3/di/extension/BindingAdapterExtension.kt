package com.botsoft.trawlbens3.di.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.botsoft.trawlbens3.R
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.ui.adapter.ListGameAdapter
import com.bumptech.glide.Glide

@BindingAdapter("usersData")
fun RecyclerView.bindRvUser(data: List<Game>?) {
    val adapter = adapter as ListGameAdapter
    adapter.submitList(data)
}

@BindingAdapter("loadUrl_circle","loadUrl_placeholder",requireAll = false)
fun ImageView.loadCircleFromUrl(url:String?, placeholder: Int?) {
    if (url == null) { return }
    Glide.with(context).load(url).circleCrop()
        .placeholder(R.drawable.ic_placeholder)
        .error(placeholder ?: R.drawable.ic_placeholder)
        .into(this)
}
