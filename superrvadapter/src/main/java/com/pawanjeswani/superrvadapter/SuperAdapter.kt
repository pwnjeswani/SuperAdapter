package com.pawanjeswani.superrvadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawanjeswani.superrvadapter.model.DummyObject
import com.pawanjeswani.superrvadapter.exception.NotSupportedViewTypeException

import java.util.ArrayList


/**
 * Base class for adding view between real data elements
 *
 *@param R is a data class for real data elements that will be used by the view holder for binding with view
 *@param RHolder is a view holder class that extends RecyclerView.ViewHolder and will be used for real elements view R binding
 *@param B is as data class for view between real elements that will be used by the other view holder for binding with view
 *@param BHolder is a view holder class that extends RecyclerView.ViewHolder and will be used for other view B (that is between real data elements) binding
 */

abstract class SuperAdapter<R, RHolder : SuperViewHolder<R>, B, BHolder : SuperViewHolder<B>> :
    ResourceAbstract, BinderAbstract<RHolder, BHolder>,
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var baseList: MutableList<Any> = ArrayList()
    private var otherViewPositions: MutableList<DummyObject<B>> = ArrayList()
    private var resetData = false

    private var lastSearchedIndex = 0


    init {
        this.createOtherItemList()
    }

    protected fun addDataToPosition(position: Int, data: B) {
        addDummyData(DummyObject(position, data))
    }

    protected fun addDummyData(dummyObject: DummyObject<B>) {
        otherViewPositions.add(dummyObject)
    }

    protected fun addAllOtherDataList(otherItemList: ArrayList<DummyObject<B>>) {
        otherItemList.sort()
        otherViewPositions.addAll(otherItemList)
    }


    override fun getItemCount(): Int {
        return baseList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (otherViewPositions.size > 0 && baseList.size > 0 && baseList[position] is DummyObject<*>)
            0
        else {

            -1
        }
    }

    protected fun getItemOnPosition(position: Int): Any {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            0 -> onCreateViewHolderBetweenElements(
                layoutInflater.inflate(
                    itemBetweenElementsResLayout,
                    parent,
                    false
                )
            )
            -1 -> onCreateRealViewHolder(
                layoutInflater.inflate(
                    realViewItemResLayout,
                    parent,
                    false
                )
            )
            else -> throw NotSupportedViewTypeException("Not support view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            if (baseList[position] is DummyObject<*>) {
                val data = genericCastOrNull<DummyObject<B>>(baseList[position])
                data?.data?.let { genericCastOrNull<SuperViewHolder<B>>(holder)?.bind(data = it) }
            }
        } else {
            if (getItemViewType(position) == -1) {
                @Suppress("UNCHECKED_CAST") val data = baseList[position] as R
                genericCastOrNull<SuperViewHolder<R>>(holder)?.bind(data = data)
            }
        }
    }


    private inline fun <reified T> genericCastOrNull(anything: Any): T? {
        return anything as? T
    }


}

