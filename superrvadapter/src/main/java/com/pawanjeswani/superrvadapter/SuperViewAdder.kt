package com.pawanjeswani.superrvadapter

import com.pawanjeswani.superrvadapter.model.DummyObject
import java.util.ArrayList

/**
 * This class is only related for moving the dummy object to  the specific position
 *
 * @param B is a data object
 *
 */
class SuperViewAdder<B> {

    private var otherViewPositions: MutableList<DummyObject<B>> = ArrayList()


    /**
     * To add data object to specific position for displaying in view
     *
     * @param position This is location(Int start from 0) where you want to add
     * @param data data object for displaying in view at the specified position
     */
    fun addDataToPosition(position: Int, data: B) {
        otherViewPositions.add(DummyObject(position, data = data))
    }

    /**
     * get  view positions  that is added from  addDataToPosition(pos,data)
     *
     * @return view positions with data object
     */
    fun getOtherViewPositions(): MutableList<DummyObject<B>> = otherViewPositions
}