package com.xgrogos.uf1m8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(llistat: ArrayList<Lol>, context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: ArrayList<Lol> = llistat;
    var context: Context? = context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNom.setText(llistat.get(position).name);
        holder.txtType.setText(llistat.get(position).type);
        holder.txtDescription.setText(llistat.get(position).description);
    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNom: TextView = view.findViewById(R.id.champion_name);
        val txtType: TextView = view.findViewById(R.id.champion_type);
        val txtDescription: TextView = view.findViewById(R.id.champion_description);
    }
}


