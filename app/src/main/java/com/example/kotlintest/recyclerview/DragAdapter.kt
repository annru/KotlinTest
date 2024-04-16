package com.example.kotlintest.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseQuickAdapter
import com.example.kotlintest.databinding.RecyclerviewItemBinding

class DragAdapter : BaseQuickAdapter<String, DragAdapter.VH>(), ItemTouchCallback {


    class VH(
        parent: ViewGroup, val binding: RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: VH, position: Int, item: String?) {
        holder.binding.passwordTv.text = item
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        return VH(parent)
    }


    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemRemove(position: Int) {
        notifyItemRemoved(position)
    }
}




