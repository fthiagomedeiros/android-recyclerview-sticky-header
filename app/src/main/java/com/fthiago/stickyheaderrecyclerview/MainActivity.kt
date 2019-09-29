package com.fthiago.stickyheaderrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fthiago.stickyheaderrecyclerview.domain.ChildItem
import com.fthiago.stickyheaderrecyclerview.adapter.DataAdapter
import com.fthiago.stickyheaderrecyclerview.adapter.StickHeaderItemDecoration
import com.fthiago.stickyheaderrecyclerview.adapter.StickyHeaderInterface
import com.fthiago.stickyheaderrecyclerview.domain.DataElement
import com.fthiago.stickyheaderrecyclerview.domain.HeaderItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRecylerView: RecyclerView
    private lateinit var mAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        mRecylerView = data_recycler_view

        mAdapter = DataAdapter(setElements())
        mRecylerView.adapter = mAdapter

        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecylerView.layoutManager = layoutManager

        mRecylerView.addItemDecoration(StickHeaderItemDecoration(mAdapter))

    }

    private fun setElements(): ArrayList<DataElement> {
        return arrayListOf(
            HeaderItem("Header 1"),
            ChildItem("Element 1.1"),
            ChildItem("Element 1.2"),
            ChildItem("Element 1.3"),
            ChildItem("Element 1.4"),
            ChildItem("Element 1.5"),
            ChildItem("Element 1.6"),
            ChildItem("Element 1.7"),
            HeaderItem("Header 2"),
            ChildItem("Element 2.1"),
            ChildItem("Element 2.2"),
            ChildItem("Element 2.3"),
            ChildItem("Element 2.4"),
            ChildItem("Element 2.5"),
            ChildItem("Element 2.6"),
            ChildItem("Element 2.7"),
            ChildItem("Element 2.8"),
            ChildItem("Element 2.9"),
            HeaderItem("Header 3"),
            ChildItem("Element 3.1"),
            ChildItem("Element 3.2"),
            ChildItem("Element 3.3"),
            ChildItem("Element 3.4"),
            ChildItem("Element 3.5"),
            ChildItem("Element 3.6"),
            ChildItem("Element 3.7"),
            ChildItem("Element 3.8"),
            ChildItem("Element 3.9"),
            ChildItem("Element 3.10"),
            ChildItem("Element 3.11"),
            ChildItem("Element 3.12"),
            ChildItem("Element 3.13"))
    }
}
