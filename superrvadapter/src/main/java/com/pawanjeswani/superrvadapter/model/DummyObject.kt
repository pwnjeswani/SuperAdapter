package com.pawanjeswani.superrvadapter.model

/**
 * This is for adding view to specific position with custom data object.
 *
 * @param T generic type for custom data
 * @property position that is location(integer) where you want to add for view.
 * @property data this is data object for displaying in view
 */
class DummyObject<T>(val position: Int, val data: T) : Comparable<DummyObject<T>> {

    override fun compareTo(other: DummyObject<T>): Int {
        //let's sort the object based on position in ascending order
        //returns a negative integer, zero, or a positive integer as this position
        //is less than, equal to, or greater than the specified object.
        return this.position - other.position
    }
}
