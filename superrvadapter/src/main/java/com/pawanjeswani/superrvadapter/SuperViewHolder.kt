package com.pawanjeswani.superrvadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SuperViewHolder<T>
    (itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(data: T)

}