package com.criticalgnome.recyclerwithtwoholders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainAdapter(private val items: List<MainItem>, private val callback: Callback): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            TYPE_DATA -> DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false))
            else -> HeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false))
        }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderHolder -> holder.bind(items[position] as ItemHeader)
            is DataHolder -> holder.bind(items[position] as ItemData)
        }
    }

    override fun getItemViewType(position: Int) =
            when (items[position]) {
                is ItemData -> TYPE_DATA
                else -> TYPE_HEADER
            }

    inner class HeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val headerText = itemView.findViewById<TextView>(R.id.text)

        fun bind(item: ItemHeader) {
            headerText.text = item.text
            itemView.setOnClickListener { callback.onItemClicked(item) }
        }
    }

    inner class DataHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val dataDate = itemView.findViewById<TextView>(R.id.date)
        private val dataName = itemView.findViewById<TextView>(R.id.name)
        private val dataId = itemView.findViewById<TextView>(R.id.id)

        fun bind(item: ItemData) {
            dataDate.text = item.date.toString()
            dataName.text = item.name
            dataId.text = item.id.toString()
            itemView.setOnClickListener { callback.onItemClicked(item) }
        }
    }

    interface Callback {
        fun onItemClicked(item: MainItem)
    }

    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_DATA = 2
    }

}