package com.xgrogos.uf1m8

import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xgrogos.uf1m8.model.ApiCall
import com.xgrogos.uf1m8.model.ModelResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_home, container, false)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.arsha.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiCall = retrofit.create(ApiCall::class.java)
        val call: Call<ArrayList<ModelResults?>?>? = apiCall.getData()
        Log.i("testApi", "hola");

        call?.enqueue(object : Callback<ArrayList<ModelResults?>?> {
            override fun onResponse(
                call: Call<ArrayList<ModelResults?>?>,
                response: Response<ArrayList<ModelResults?>?>
            ) {
                Log.i("testApi", response.code().toString()+ "");
                Log.i("testApi", response.body()?.get(0)?.name.toString())

                val recyclerView: RecyclerView = v.findViewById(R.id.recycler_home_list)
                recyclerView.layoutManager = LinearLayoutManager(context)
                val adapter: RecyclerHomeAdapter = RecyclerHomeAdapter(response.body()!!,context)
                recyclerView.adapter = adapter
                recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
            }

            override fun onFailure(call: Call<ArrayList<ModelResults?>?>, t: Throwable) {
                Log.i("testApi", "ko");

            }

        });



/*
        call?.enqueue(object : Callback<ArrayList<ModelResults?>?> {
            override fun onResponse(
                call: Call<ArrayList<ModelResults?>?>,
                response: Response<ArrayList<ModelResults?>?>
            ) {
                if (response.code() !== 200) {
                    Log.i("testApi", "checkConnection")
                    return
                }
                    val recyclerView: RecyclerView = v.findViewById(R.id.recycler_home_list)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    val adapter: RecyclerHomeAdapter = RecyclerHomeAdapter(response.body()!!,context)
                    recyclerView.adapter = adapter
                    recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
            }

            override fun onFailure(call: Call<ArrayList<ModelResults?>?>, t: Throwable) {
                Log.i("testApi","Connection Failure")
            }
        })*/
        return v;
    }
}