package com.exxuslee.testprofitof.ui.first

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exxuslee.testprofitof.R


class FirstAdapter :
    ListAdapter<Int, FirstAdapter.FirstHolder>(FirstDiffCallback()) {

    var onIDClickListener: ((Int) -> Unit)? = null
    private var selectedPosition = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_fist, parent, false)
        return FirstHolder(view)
    }

    override fun onBindViewHolder(holder: FirstHolder, position: Int) {
        holder.name.text = getItem(position).toString()
        holder.itemView.setBackgroundColor(if (selectedPosition == position) Color.LTGRAY else Color.TRANSPARENT)
        holder.itemView.setOnClickListener {
            notifyItemChanged(selectedPosition)
            selectedPosition = holder.adapterPosition
            notifyItemChanged(position)
            onIDClickListener?.invoke(position)
        }
    }

    fun updateAdapter(ids: IntArray?) {
        submitList(ids?.toList())
    }

    class FirstHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
    }

}