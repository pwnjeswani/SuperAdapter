package com.pawanjeswani.superrvadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawanjeswani.superrvadapter.model.DummyObject
import com.pawanjeswani.superrvadapter.exception.NotSupportedViewTypeException



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

    private val dummyToPosition: SuperViewAdder<B> = SuperViewAdder()
    private val superBaseList: SuperBaseList<B> = SuperBaseList(superViewAdder = dummyToPosition)


    init {
        this.createOtherItemList()
    }

    protected fun setBaseList(data: List<Any>) = superBaseList.setBaseList(data)

    protected fun getSuperViewAdder(): SuperViewAdder<B> = dummyToPosition

    override fun getItemCount(): Int {
        return superBaseList.getBaseList().size
    }

    override fun getItemViewType(position: Int): Int {
        return if (dummyToPosition.getOtherViewPositions().size > 0 && superBaseList.getBaseList().size > 0 && superBaseList.getBaseList()[position] is DummyObject<*>)
            0
        else {

            -1
        }
    }

    protected fun getItemOnPosition(position: Int): Any {
        return superBaseList.getBaseList()[position]
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
            if (superBaseList.getBaseList()[position] is DummyObject<*>) {
                val data = genericCastOrNull<DummyObject<B>>(superBaseList.getBaseList()[position])
                data?.data?.let { genericCastOrNull<SuperViewHolder<B>>(holder)?.bind(data = it) }
            }
        } else {
            if (getItemViewType(position) == -1) {
                @Suppress("UNCHECKED_CAST") val data = superBaseList.getBaseList()[position] as R
                genericCastOrNull<SuperViewHolder<R>>(holder)?.bind(data = data)
            }
        }
    }


    private inline fun <reified T> genericCastOrNull(anything: Any): T? {
        return anything as? T
    }


}

