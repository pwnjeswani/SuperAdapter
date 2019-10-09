package com.pawanjeswani.superrvadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SuperViewHolder<T>
    (itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * For bind data with view
     *
     * @param data this is data class for binding with view
     */
    abstract fun bind(data: T)

}