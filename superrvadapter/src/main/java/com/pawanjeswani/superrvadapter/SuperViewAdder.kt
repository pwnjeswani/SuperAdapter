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


    fun addDataToPosition(position: Int, data: B) {
        otherViewPositions.add(DummyObject(position, data = data))
    }

    fun getOtherViewPositions(): MutableList<DummyObject<B>> = otherViewPositions
}