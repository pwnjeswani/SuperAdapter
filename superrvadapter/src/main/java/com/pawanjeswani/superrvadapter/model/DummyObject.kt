package com.pawanjeswani.superrvadapter.model

class DummyObject(var itemViewType: Int, var position: Int) : Comparable<DummyObject> {

    override fun compareTo(dummyObject: DummyObject): Int {
        //let's sort the object based on position in ascending order
        //returns a negative integer, zero, or a positive integer as this position
        //is less than, equal to, or greater than the specified object.
        return this.position - dummyObject.position
    }
}
