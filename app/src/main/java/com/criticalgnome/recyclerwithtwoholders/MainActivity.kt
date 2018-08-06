package com.criticalgnome.recyclerwithtwoholders

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var id = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
                ItemHeader("January"),
                ItemData(getId(), getCalendar(5,1,1976), "Sergey"),
                ItemHeader("February"),
                ItemData(getId(), getCalendar(22,2,1978), "Ippolit"),
                ItemData(getId(), getCalendar(23,2,1979), "Dmitry"),
                ItemHeader("June"),
                ItemData(getId(), getCalendar(1,6,1937), "Alla"),
                ItemData(getId(), getCalendar(11,6, 1981), "Roman"),
                ItemHeader("Jule"),
                ItemData(getId(), getCalendar(15,7,2006), "Viktor"),
                ItemHeader("September"),
                ItemData(getId(), getCalendar(1,9,1939), "Nikolay"),
                ItemHeader("December"),
                ItemData(getId(), getCalendar(1,9,1978), "Irina")
        )

        val mainAdapter = MainAdapter(items, object : MainAdapter.Callback {
            override fun onItemClicked(item: MainItem) {
                when (item) {
                    is ItemHeader -> Toast.makeText(this@MainActivity, item.text, Toast.LENGTH_SHORT).show()
                    is ItemData -> Toast.makeText(this@MainActivity, item.name, Toast.LENGTH_SHORT).show()
                }
            }
        })
        mainRecycler.adapter = mainAdapter
    }

    private fun getCalendar(date: Int, month: Int, year: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, date)
        return calendar
    }

    private fun getId() = id++
}
