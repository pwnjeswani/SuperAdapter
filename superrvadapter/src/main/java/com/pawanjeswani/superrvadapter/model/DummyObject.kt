package com.pawanjeswani.superrvadapter.model



class DummyObject<T>(val position:Int, override val data: T) : Comparable<DummyObject<T>>, DataForOther<T>() {

    override fun compareTo(other: DummyObject<T>): Int {
        //let's sort the object based on position in ascending order
        //returns a negative integer, zero, or a positive integer as this position
        //is less than, equal to, or greater than the specified object.
        return this.position - other.position
    }
}
