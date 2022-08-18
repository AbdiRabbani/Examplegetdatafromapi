package com.example.apiapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class CatAdapter(private val listCat : ArrayList<DataResponseItem>) : RecyclerView.Adapter<CatAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            Picasso.get().load(listCat[position].url).into(ivParent)
        }
    }

    override fun getItemCount() =listCat.size

}