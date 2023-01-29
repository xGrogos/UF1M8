package com.xgrogos.uf1m8.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {
    @GET("v2/eu/GetWorldMarketWaitList")
    fun getData(): Call<ArrayList<ModelResults?>?>?

  /*
    @GET("json?") // the getter formats the information in json.
    fun getData(@Query("lat") lat: String?, @Query("lng") lng: String?): Call<ModelResults?>
*/
}