package com.example.agdu.exampleapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agdu.exampleapp.R
import kotlinx.android.synthetic.main.item_display_name.view.*

/**
 * Created by agdu on 2017-04-19.
 */

class RvAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<String>

    init {
        items = ArrayList()
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RvViewHolder(parent!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder as RvViewHolder
        holder.bind(items!![position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(itemss: List<String>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    fun addSingleElement(displayName: String) {
        items.add(displayName)
        notifyDataSetChanged()
    }

    inner class RvViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_display_name)) {

        fun bind(item: String) = with(itemView){
            display_name_tv.text = item
        }
    }

}

private fun ViewGroup.inflate(layoutId: Int): View? {

   return LayoutInflater.from(context).inflate(layoutId, this, false)

}


