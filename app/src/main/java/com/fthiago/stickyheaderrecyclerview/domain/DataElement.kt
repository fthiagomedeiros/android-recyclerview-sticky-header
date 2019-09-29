package com.fthiago.stickyheaderrecyclerview.domain

abstract class DataElement(var info: String) {

    object HEADER {
        const val HEADER_ELEMENT = 1
        const val CHILD_ELEMENT = 2
    }

    abstract fun getType(): Int
}