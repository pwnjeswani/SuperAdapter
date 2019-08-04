package com.pawanjeswani.superrvadapter


import androidx.recyclerview.widget.RecyclerView
import com.pawanjeswani.superrvadapter.model.DummyObject

import java.util.ArrayList
import java.util.Collections

abstract class SuperAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var baseList: MutableList<Any> = ArrayList()
    protected var otherViewPositions: MutableList<DummyObject> = ArrayList()
    protected var resetData = false

    private var lastSearchedIndex = 0

    constructor() : super() {}

    constructor(otherViewPositions: ArrayList<DummyObject>) {
        otherViewPositions.sort()
        this.otherViewPositions = otherViewPositions
    }
    protected abstract fun createOtherItemList()

    override fun getItemCount(): Int {
        return baseList.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (otherViewPositions.size > 0 && baseList.size > 0 && baseList[position] is DummyObject)
            (baseList[position] as DummyObject).itemViewType
        else {

            -1
        }
    }

    protected fun getItemOnPosition(position:Int):Any{
        return baseList[position]
    }

    protected fun setBaseList(baseList: List<Any>) {
        if (resetData) {
            this.baseList.clear()
            resetData = false
            this.lastSearchedIndex = 0
        }
        this.baseList.addAll(baseList)
        checkItemToBeInserted()

    }

    private fun checkItemToBeInserted() {
        val localSearchIndex = this.lastSearchedIndex
        for (i in localSearchIndex until otherViewPositions.size) {

            if (otherViewPositions[i].position <= baseList.size) {

                baseList.add(otherViewPositions[i].position, otherViewPositions[i])
                this.lastSearchedIndex = i + 1

            }
        }
    }
}

