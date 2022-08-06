package com.exxuslee.testprofitof.ui.list

import androidx.recyclerview.widget.DiffUtil

class RatesDiffCallback : DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(
        oldItem: Int, newItem: Int,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Int, newItem: Int,
    ): Boolean {
        return oldItem == newItem
    }
}