package com.pawanjeswani.superrvadapter

import android.view.View

internal interface BinderAbstract<RH, BH> {
    /**
     * For creating view holder for views between elements from
     * @param view
     * And return the view holder
     */
    fun onCreateViewHolderBetweenElements(view: View): BH

    /**
     * For creating view holder for real view  from
     * @param view
     * And return the view holder
     */
    fun onCreateRealViewHolder(view: View): RH

    /**
     * for creating other item with DummyObject
     */
    fun createOtherItemList()


}