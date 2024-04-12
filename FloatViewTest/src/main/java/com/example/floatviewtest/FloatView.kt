package com.example.floatviewtest

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.imageview.ShapeableImageView

class FloatView : FrameLayout, View.OnTouchListener {

    private var mDownX = 0F
    private var mDownY = 0F

    private var mViewWidth = 0
    private var mViewHeight = 0


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    constructor(
        context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        initView()
    }


    private fun initView() {
        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        layoutParams = lp

        val imageView = ShapeableImageView(context)
        imageView.setImageResource(R.mipmap.ic_avatar)

        addView(imageView)

        setOnTouchListener(this)

        post {
            mViewWidth = this.width
            mViewHeight = this.height
        }

        post {

        }

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        event?.let {
            val x = event.x
            val y = event.y
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mDownX = event.x
                    mDownY = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    offsetTopAndBottom((y - mDownY).toInt())
                    offsetLeftAndRight((x - mDownX).toInt())
                }
                MotionEvent.ACTION_UP -> {

                }
            }
        }

        return true
    }
}