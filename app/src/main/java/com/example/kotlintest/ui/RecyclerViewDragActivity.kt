package com.example.kotlintest.ui

import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.kotlintest.ArouterPath
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityRecyclerviewDragBinding
import com.example.kotlintest.recyclerview.DragAdapter
import com.example.kotlintest.recyclerview.GridItemTouchCallback


/**
 * 拖拽效果
 */
@Route(path = ArouterPath.RecyclerViewDragActivity)
class RecyclerViewDragActivity : BaseActivity<ActivityRecyclerviewDragBinding>() {

    override fun setContentView(): Int = R.layout.activity_recyclerview_drag

    private val dragAdapter = DragAdapter()

    private val data = mutableListOf("11", "22", "33")

    override fun init(bundle: Bundle?) {

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewBinding.recyclerViewDrag.layoutManager = linearLayoutManager
        dragAdapter.submitList(data)
        viewBinding.recyclerViewDrag.adapter = dragAdapter

        val itemTouchHelper = ItemTouchHelper(GridItemTouchCallback(dragAdapter))
        itemTouchHelper.attachToRecyclerView(viewBinding.recyclerViewDrag)

    }

}