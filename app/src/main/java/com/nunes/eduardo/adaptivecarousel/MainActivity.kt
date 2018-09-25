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
                "nothing", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada", "tudo", "nada")

        val viewAdapter = MyAdapter(items)

        flexCollection.apply {
            adapter = viewAdapter
        }

        switch1.setOnCheckedChangeListener { _, b ->
            if (b){
                switch1.text = getString(R.string.horizontal)
                flexCollection.layoutFormat = 1
            }else{
                switch1.text = getString(R.string.grid)
                flexCollection.layoutFormat = 3
            }
        }
    }
}
