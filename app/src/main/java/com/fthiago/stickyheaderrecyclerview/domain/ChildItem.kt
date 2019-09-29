package com.fthiago.stickyheaderrecyclerview.domain

import com.fthiago.stickyheaderrecyclerview.domain.DataElement.HEADER.CHILD_ELEMENT

class ChildItem(info: String) : DataElement(info) {

    override fun getType(): Int {
        return CHILD_ELEMENT
    }

}