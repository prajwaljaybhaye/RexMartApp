package com.codewithandro.api28days

import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: ProductsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        //first api
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface ::class.java)

        //get the data class -> fetch the json data class inside method use
        val retrofitData = retrofitBuilder.getProductData()

        //prograess bar
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Wait Featching Products")
        progressDialog.show()

        //call the enqueue function the provide the response method
        retrofitData.enqueue(object : Callback<ProductsData> {
            override fun onResponse(call: Call<ProductsData>, response: Response<ProductsData>) {
                //if api call success to call the function
                progressDialog.dismiss()
                //assign the response.body()
                val responseBody = response.body()
                //access the dataClass variables -> fetch the arrayList
                //data Class -> ready arrayList ready data
                val productDataList = responseBody?.products//pass the data list to the adapter

                //create recyclerView and Adapter class
                recyclerView = findViewById(R.id.recyclerView)
                myAdapter = ProductsAdapter(this@MainActivity,productDataList)

                recyclerView.layoutManager = GridLayoutManager(this@MainActivity,1)
                recyclerView.adapter =myAdapter


            }

            override fun onFailure(call: Call<ProductsData>, response: Throwable) {
               //if api is fails then call the function
                progressDialog.dismiss()
            }

        })

    }

}