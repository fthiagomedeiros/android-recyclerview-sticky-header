package com.fthiago.stickyheaderrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fthiago.stickyheaderrecyclerview.R
import com.fthiago.stickyheaderrecyclerview.databinding.DataItemBinding
import com.fthiago.stickyheaderrecyclerview.databinding.HeaderBinding
import com.fthiago.stickyheaderrecyclerview.domain.ChildItem
import com.fthiago.stickyheaderrecyclerview.domain.DataElement
import com.fthiago.stickyheaderrecyclerview.domain.DataElement.HEADER.HEADER_ELEMENT
import com.fthiago.stickyheaderrecyclerview.domain.HeaderItem


class DataAdapter(private var mData: ArrayList<DataElement>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), StickyHeaderInterface {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_ELEMENT) {
            val inflater =
                LayoutInflater
                    .from(parent.context).inflate(R.layout.header, parent, false)
            HeaderViewHolder(inflater)

        } else {
            val inflater =
                LayoutInflater
                    .from(parent.context).inflate(R.layout.data_item, parent, false)
            DataViewHolder(inflater)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        if (mData[position].getType() == HEADER_ELEMENT) {
            val holderElement = holder as HeaderViewHolder
            holderElement.binding.itemHeader = mData[position] as HeaderItem
            holderElement.binding.executePendingBindings()

        } else {
            val holderElement = holder as DataViewHolder
            holderElement.binding.itemData = mData[position] as ChildItem
            holderElement.binding.executePendingBindings()

        }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return mData[position].getType()
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        var position = itemPosition
        var headerPosition = 0
        do {
            if (this.isHeader(position)) {
                headerPosition = position
                break
            }
            position -= 1
        } while (position >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return if (mData[headerPosition].getType() == HEADER_ELEMENT) {
            R.layout.header
        } else {
            R.layout.data_item
        }
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {
        if (mData[headerPosition].getType() == 1) {
            val textView = header.findViewById<TextView>(R.id.header_text)
            textView.text = mData[headerPosition].info
        }
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return mData[itemPosition].getType() == HEADER_ELEMENT
    }

}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: HeaderBinding = HeaderBinding.bind(itemView)
}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: DataItemBinding = DataItemBinding.bind(itemView)
}