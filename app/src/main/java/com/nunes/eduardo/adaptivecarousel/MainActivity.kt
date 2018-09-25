package com.nunes.eduardo.adaptivecarousel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("tudo", "nada", "tudo", "nada", "all", "nothing", "tudo",
                "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada",
                "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "all",
                "nothing", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada")
        val viewManager = GridLayoutManager(this,1)
        val viewAdapter = MyAdapter(items)

        horizontal_recycler_view.apply {
            setHasFixedSize(true)

            viewManager.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = viewManager

            val itemDecoration = ItemOffsetDecoration(context, R.dimen.item_offset)
            addItemDecoration(itemDecoration)

            adapter = viewAdapter
        }

        switch1.setOnCheckedChangeListener { _, b ->
            horizontal_recycler_view.isHorizontalScrollBarEnabled = b
            horizontal_recycler_view.isVerticalScrollBarEnabled = !b
            if (b){
                switch1.text = getString(R.string.horizontal)
                viewManager.spanCount = 1
                viewManager.orientation = LinearLayoutManager.HORIZONTAL
            }else{
                switch1.text = getString(R.string.grid)
                viewManager.spanCount = 3
                viewManager.orientation = LinearLayoutManager.VERTICAL
            }
        }
    }
}
