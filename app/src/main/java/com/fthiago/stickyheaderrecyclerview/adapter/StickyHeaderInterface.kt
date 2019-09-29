package com.fthiago.stickyheaderrecyclerview.adapter

import android.view.View

interface StickyHeaderInterface {
    fun getHeaderPositionForItem(itemPosition: Int): Int
    fun getHeaderLayout(headerPosition: Int): Int
    fun bindHeaderData(header: View, headerPosition: Int)
    fun isHeader(itemPosition: Int): Boolean
}