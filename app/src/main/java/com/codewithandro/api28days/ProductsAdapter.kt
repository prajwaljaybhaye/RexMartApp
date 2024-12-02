package com.codewithandro.api28days

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Callback
import kotlin.Int
import kotlin.Int as Int1

class ProductsAdapter(var context: Activity, var prodArrayList: List<Product>?):
RecyclerView.Adapter<ProductsAdapter.MyViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int1): MyViewHolder {

        val inflater = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int1) {

        // box 1 create current
        var currentItem = prodArrayList?.get(position+2)

        holder.ratingBar.text = currentItem?.rating.toString()
        //use image 3 rd parti laibrary picasso
        Picasso.get().load(currentItem?.thumbnail).into(holder.productImg)
        holder.prodTitle.text = currentItem?.title
        holder.prodDes.text = currentItem?.description
        holder.price.text = "$ "+currentItem?.price?.toString()

        //box 2
        //create current

        var currentItem1 = prodArrayList?.get(position+6)
        holder.ratingBar1.text = currentItem1?.rating.toString()
        //use image 3 rd parti laibrary picasso
        Picasso.get().load(currentItem1?.thumbnail).into(holder.productImg1)
        holder.prodTitle1.text = currentItem1?.title
        holder.prodDes1.text = currentItem1?.description
        holder.price1.text = "$ "+currentItem1?.price?.toString()


    }

    override fun getItemCount(): Int {
        return prodArrayList?.size!!
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            // 1st box featch the recycler view -> views
            val ratingBar = itemView.findViewById<TextView>(R.id.ratingBar)
            val productImg = itemView.findViewById<ImageView>(R.id.prodImg)
            val prodTitle = itemView.findViewById<TextView>(R.id.prodTitle)
            val prodDes = itemView.findViewById<TextView>(R.id.prodDes)
            val price = itemView.findViewById<TextView>(R.id.price)


        //2nd box featch the recycler view -> views
        val ratingBar1 = itemView.findViewById<TextView>(R.id.ratingBar1)
        val productImg1 = itemView.findViewById<ImageView>(R.id.prodImg1)
        val prodTitle1 = itemView.findViewById<TextView>(R.id.prodTitle1)
        val prodDes1 = itemView.findViewById<TextView>(R.id.prodDes1)
        val price1 = itemView.findViewById<TextView>(R.id.price1)





    }

}