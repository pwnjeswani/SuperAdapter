package com.pawanjeswani.superrvadapter

/**
 * For set data list and add other view to add the specific position got from Super View Adder
 *
 * @param B is data object for Super View Adder
 * @property superViewAdder For get the postion and data object
 *
 */
internal class SuperBaseList<B>(private val superViewAdder: SuperViewAdder<B>) {

    private val baseList: MutableList<Any> = ArrayList()
    private var resetData = false
    private var lastSearchedIndex = 0

    fun getBaseList(): MutableList<Any> = baseList


    fun setBaseList(baseList: List<Any>) {
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
        val otherViewPositions = superViewAdder.getOtherViewPositions()
        for (i in localSearchIndex until otherViewPositions.size) {

            if (otherViewPositions[i].position <= baseList.size) {

                baseList.add(otherViewPositions[i].position, otherViewPositions[i])
                this.lastSearchedIndex = i + 1

            }
        }
    }


}