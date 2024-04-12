package com.example.kotlintest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.random.Random

class WaveformView : SurfaceView, SurfaceHolder.Callback, Runnable {
    private lateinit var surfaceHolder: SurfaceHolder

    private lateinit var canvas: Canvas

    private var thread: Thread? = Thread(this, "绘图线程")

    private var isDrawing = false

    private val paint: Paint = Paint()


    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }


    private fun init() {
        surfaceHolder = holder
        surfaceHolder.addCallback(this)
        paint.color = Color.RED
        paint.strokeWidth = 10F
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        isDrawing = true
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        isDrawing = false
        try {
            //等待子线程结束，并释放子线程对象
            thread?.join()
            thread = null
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        while (isDrawing) {
            //获取当前时间，用于计算绘制时间
            val start = System.currentTimeMillis()
            //调用draw方法进行绘制操作
            draw()
            //获取结束时间，用于计算绘制时间
            val end = System.currentTimeMillis()
            //如果绘制时间小于16ms，则延时一段时间，保证每秒60帧的刷新率
            if (end - start < 16) {
                try {
                    Thread.sleep(500 - (end - start))
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun draw() {
        try {
            canvas = holder.lockCanvas()
            val random = Random.Default
            val points = mutableListOf<Point>()
            for (i in 0..9) {
                val x = random.nextInt(canvas.width)
                val y = random.nextInt(canvas.height)
                points.add(Point(x, y))
            }
            //遍历点的集合，用画笔连接相邻的两个点，形成一条折线图
            for (i in 0 until points.size - 1) {
                val p1 = points[i]
                val p2 = points[i + 1]
                canvas.drawLine(
                    p1.x.toFloat(), p1.y.toFloat(), p2.x.toFloat(), p2.y.toFloat(), paint
                )
            }
            holder.unlockCanvasAndPost(canvas)
        } catch (_: Exception) {

        }

    }
}