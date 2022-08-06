package com.exxuslee.testprofitof.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exxuslee.domain.models.IDs
import com.exxuslee.testprofitof.R


class FirstAdapter :
    ListAdapter<Int, FirstAdapter.FirstHolder>(RatesDiffCallback()) {

    var onPriceClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_fist, parent, false)
        return FirstHolder(view)
    }

    override fun onBindViewHolder(viewHolder: FirstHolder, position: Int) {
        viewHolder.name.text = getItem(position).toString()
        viewHolder.itemView.setOnClickListener {
            onPriceClickListener?.invoke(position)
        }
    }

    fun updateAdapter(ids: IDs?) {
        submitList(ids?.list?.toList())
    }

    class FirstHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
    }

}