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
                ItemHeader("Январь"),
                ItemData(getId(), getCalendar(10, Calendar.JANUARY, 1883), "Алексей Николаевич Толстой"),
                ItemData(getId(), getCalendar(29, Calendar.JANUARY, 1860), "Антон Павлович Чехов"),
                ItemHeader("Февраль"),
                ItemData(getId(), getCalendar(10, Calendar.FEBRUARY, 1890), "Борис Леонидович Пастернак"),
                ItemData(getId(), getCalendar(16, Calendar.FEBRUARY, 1831), "Николай Семёнович Лесков"),
                ItemHeader("Март"),
                ItemData(getId(), getCalendar(28, Calendar.MARCH, 1868), "Максим Горький"),
                ItemHeader("Апрель"),
                ItemData(getId(), getCalendar(12, Calendar.APRIL, 1823), "Александр Николаевич Островский"),
                ItemHeader("Июнь"),
                ItemData(getId(), getCalendar( 6, Calendar.JUNE, 1799), "Александр Сергеевич Пушкин"),
                ItemData(getId(), getCalendar(23, Calendar.JUNE, 1889), "Анна Андреевна Ахматова"),
                ItemHeader("Июль"),
                ItemData(getId(), getCalendar(19, Calendar.JULY, 1893), "Владимир Владимирович Маяковский"),
                ItemData(getId(), getCalendar(27, Calendar.JULY, 1853), "Владимир Галактионович Короленко"),
                ItemHeader("Сентябрь"),
                ItemData(getId(), getCalendar( 9, Calendar.SEPTEMBER, 1828), "Лев Николаевич Толстой"),
                ItemHeader("Октябрь"),
                ItemData(getId(), getCalendar( 3, Calendar.OCTOBER, 1895), "Сергей Александрович Есенин"),
                ItemData(getId(), getCalendar( 7, Calendar.OCTOBER, 1870), "Александр Иванович Куприн"),
                ItemData(getId(), getCalendar(15, Calendar.OCTOBER, 1814), "Михаил Юрьевич Лермонтов"),
                ItemData(getId(), getCalendar(22, Calendar.OCTOBER, 1870), "Иван Алексеевич Бунин"),
                ItemHeader("Ноябрь"),
                ItemData(getId(), getCalendar( 9, Calendar.NOVEMBER, 1818), "Иван Сергеевич Тургенев"),
                ItemData(getId(), getCalendar(11, Calendar.NOVEMBER, 1821), "Фёдор Михайлович Достоевский"),
                ItemData(getId(), getCalendar(28, Calendar.NOVEMBER, 1880), "Александр Александрович Блок"),
                ItemHeader("Декабрь"),
                ItemData(getId(), getCalendar( 5, Calendar.DECEMBER, 1803), "Фёдор Иванович Тютчев"),
                ItemData(getId(), getCalendar( 5, Calendar.DECEMBER, 1820), "Афанасий Афанасьевич Фет"),
                ItemData(getId(), getCalendar(10, Calendar.DECEMBER, 1821), "Николай Алексеевич Некрасов"),
                ItemData(getId(), getCalendar(13, Calendar.DECEMBER, 1873), "Валерий Яковлевич Брюсов")
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
