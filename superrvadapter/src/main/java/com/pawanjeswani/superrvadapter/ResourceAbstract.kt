package com.pawanjeswani.superrvadapter

import androidx.annotation.LayoutRes

internal interface ResourceAbstract {
    /**
     * For real view layout
     *
     * @return resource layout id
     */
    @get:LayoutRes
    val realViewItemResLayout: Int

    /**
     * For  view layout between real view elements
     *
     * @return resource layout id
     */
    @get:LayoutRes
    val itemBetweenElementsResLayout: Int
}