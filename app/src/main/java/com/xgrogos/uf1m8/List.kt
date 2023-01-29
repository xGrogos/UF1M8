package com.xgrogos.uf1m8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xgrogos.uf1m8.DB.LolDBHelper

class List(dbH: LolDBHelper) : Fragment() {
    private val dbHelper = dbH; // dabatabe helper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_list, container, false) // View for the layout fragment
        val championList: ArrayList<Lol> = dbHelper.getAllChampions() // This is an array that will list all the champions.
        val recyclerView: RecyclerView = v.findViewById(R.id.recycler_list) // This is the recycler viewer of the List
        recyclerView.layoutManager = LinearLayoutManager(context) // i dont understand what this does, it could be that it manages the layout of the List of the Champions in the RecyclerViewer
        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(championList, context); 
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        return v;
        }
}