package com.example.kotlintest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseQuickAdapter
import com.example.kotlintest.databinding.RecyclerviewItemBinding

class BannerAdapter(private val onClick: (String) -> Unit) :
    BaseQuickAdapter<String, BannerAdapter.VH>() {


    class VH(
        parent: ViewGroup, val binding: RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: VH, position: Int, item: String?) {
        holder.binding.passwordTv.text = item
        item?.let {
            holder.binding.container.setOnClickListener { onClick.invoke(item) }
        }
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        return VH(parent)
    }

}




