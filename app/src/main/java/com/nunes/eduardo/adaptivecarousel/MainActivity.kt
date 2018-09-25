package com.nunes.eduardo.adaptivecarousel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("tudo", "nada", "tudo", "nada", "all", "nothing", "tudo",
                "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada",
                "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "all",
                "nothing", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo",
                "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada")

        val viewAdapter = MyAdapter(items)

        flexCollection.apply {
            adapter = viewAdapter
        }

        radioButton.setOnClickListener {
            flexCollection.layoutFormat = 1
        }

        radioButton2.setOnClickListener {
            flexCollection.layoutFormat = 2
        }

        radioButton3.setOnClickListener {
            flexCollection.layoutFormat = 3
        }

        radioButton4.setOnClickListener {
            flexCollection.layoutFormat = 4
        }
    }
}
