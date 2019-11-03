package com.example.kotlinkoinmvp.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinkoinmvp.R
import com.example.kotlinkoinmvp.model.catts


class CatsAdapter (private var context: Activity, private var dataList:ArrayList<catts>):
    RecyclerView.Adapter<CatsAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return dataList.size;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cats_list, parent, false))
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
//            holder.textView.text=dataList[position].title
        Glide.with(holder.itemView.context)
            .load(dataList[position].url)
            .into(  holder.imageview)
//        if(dataList[position]!= null){
//            holder.imageview.setOnClickListener(View.OnClickListener {
//                holder.itemView.context.startActivity(
//                    Intent(holder.itemView.context, DetailsActivity::class.java)
//                        .putExtra("value1",dataList[position])
//                )
//
//            })
//        }
    }

    fun updatelist(list: List<catts>){
        dataList.addAll(list)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView =itemView.findViewById(R.id.image1)
    }
}