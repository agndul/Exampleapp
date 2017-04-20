package com.example.agdu.exampleapp.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.agdu.exampleapp.R
import com.example.agdu.exampleapp.common.inflate
import kotlinx.android.synthetic.main.item_display_name.view.*

/**
 * Created by agdu on 2017-04-19.
 */

class RvAdapter(val actionCallback: onViewClickedListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<String> = ArrayList()

    interface onViewClickedListener {
        fun onItemClicked(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RvViewHolder(parent!!.inflate(R.layout.item_display_name)!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? RvViewHolder)?.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(itemss: List<String>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    inner class RvViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) = with(itemView){
            display_name_tv.text = item
            display_name_tv.setOnClickListener { actionCallback.onItemClicked(layoutPosition) }
        }
    }

}


