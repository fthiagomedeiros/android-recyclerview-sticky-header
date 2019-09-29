package com.fthiago.stickyheaderrecyclerview.domain

import com.fthiago.stickyheaderrecyclerview.domain.DataElement.HEADER.HEADER_ELEMENT

class HeaderItem(info: String) : DataElement(info) {

    override fun getType(): Int {
        return HEADER_ELEMENT
    }

}