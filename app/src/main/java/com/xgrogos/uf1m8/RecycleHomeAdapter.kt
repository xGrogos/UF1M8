package com.xgrogos.uf1m8

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.xgrogos.uf1m8.model.ModelResults
import retrofit2.Response
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

class RecyclerHomeAdapter(ll: ArrayList<ModelResults?>, context: Context?): RecyclerView.Adapter<RecyclerHomeAdapter.ViewHolder>() {
    var llistat: ArrayList<ModelResults?> = ll;
    var context: Context? = context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.home_list, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stamp = Timestamp(llistat.get(position)?.liveAt!!)
        val date = Date(stamp.time)
        holder.txtName.setText(llistat.get(position)!!.name);
        holder.txtPrice.setText(""+llistat.get(position)!!.price);
        holder.txtTime.setText(""+date);

    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.item_name);
        val txtPrice: TextView = view.findViewById(R.id.item_price);
        val txtTime: TextView = view.findViewById(R.id.item_time);
    }
}


