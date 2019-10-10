package com.pawanjeswani.superrvadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * This is base view holder for binding view with data.
 *
 * @property itemView this is view from inflating the layout resource
 * @constructor create view holder with item view
 *
 */
abstract class SuperViewHolder<T>
    (itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * For bind data with view
     *
     * @param data this is data class for binding with view
     */
    abstract fun bind(data: T)

}