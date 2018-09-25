package com.nunes.eduardo.adaptivecarousel

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

/**
 * Component prepared to work in 3 ways, horizontal and vertical list, or vertical grid
 */
class FlexCollection : RecyclerView {

    private var _layoutFormat: Int = 0
    private var _item_offset: Float = 0f

    var layoutFormat: Int
        get() = _layoutFormat
        set(value) {
            _layoutFormat = value
            invalidateLayout()
        }

    private val viewManager: GridLayoutManager by lazy {
        GridLayoutManager(context,1)
    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        initAttrs(attrs, defStyle)

        initView()

        invalidateLayout()
    }

    private fun initAttrs(attrs: AttributeSet?, defStyle: Int){
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.FlexCollection, defStyle, 0)
        _layoutFormat = a.getColor(R.styleable.FlexCollection_layout_format, _layoutFormat)
        _item_offset = a.getDimension(R.styleable.FlexCollection_item_offset, _item_offset)
        a.recycle()
    }

    private fun initView(){
        layoutManager = viewManager
        setHasFixedSize(true)

        val itemDecoration = ItemOffsetDecoration(_item_offset.toInt())
        addItemDecoration(itemDecoration)
    }

    private fun invalidateLayout() {
        when(_layoutFormat){
            1 -> {
                isHorizontalScrollBarEnabled = true
                isVerticalScrollBarEnabled = false
                viewManager.spanCount = 1
                viewManager.orientation = LinearLayoutManager.HORIZONTAL
            }
            2 -> {

            }
            3 -> {
                isHorizontalScrollBarEnabled = false
                isVerticalScrollBarEnabled = true
                viewManager.spanCount = 4
                viewManager.orientation = LinearLayoutManager.VERTICAL
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        val paddingLeft = paddingLeft
//        val paddingTop = paddingTop
//        val paddingRight = paddingRight
//        val paddingBottom = paddingBottom
//
//        val contentWidth = width - paddingLeft - paddingRight
//        val contentHeight = height - paddingTop - paddingBottom


//        exampleDrawable?.let {
//            it.setBounds(paddingLeft, paddingTop,
//                    paddingLeft + contentWidth, paddingTop + contentHeight)
//            it.draw(canvas)
//        }
    }
}
