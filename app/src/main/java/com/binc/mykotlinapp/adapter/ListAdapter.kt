package com.binc.mykotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binc.mykotlinapp.R
import com.binc.mykotlinapp.bean.Item
import kotlinx.android.synthetic.main.rv_item.view.*

class ListAdapter(val items: List<Item>?, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false))
    }

    override fun getItemCount(): Int {
        if (items == null)
            return 0
        else
            return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.tvItem?.text = items?.get(position)?.item
    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvItem = view.tv_item
}