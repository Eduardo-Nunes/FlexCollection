package com.nunes.eduardo.adaptivecarousel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("0", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38",
                "39", "40", "41", "42", "43", "44", "45", "46", "47")

        val viewAdapter = MyAdapter(items)

        flexCollection.apply {
            adapter = viewAdapter
        }

        radioButton.setOnClickListener {
            flexCollection.layoutFormat = CollectionLayoutFormat.HORIZONTAL
        }

        radioButton2.setOnClickListener {
            flexCollection.layoutFormat = CollectionLayoutFormat.VERTICAL
        }

        radioButton3.setOnClickListener {
            flexCollection.layoutFormat = CollectionLayoutFormat.GRID
        }

        radioButton4.setOnClickListener {
            flexCollection.layoutFormat = CollectionLayoutFormat.HORIZONTAL
        }
    }
}
