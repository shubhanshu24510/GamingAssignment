package com.shubhans.gamingassignment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhans.gamingassignment.R
import com.shubhans.gamingassignment.data.model.Cat

class CatAdapter(
    private val cats: List<Cat>,
    private val onItemClick: (Cat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImage: ImageView = itemView.findViewById(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]

        Glide.with(holder.itemView)
            .load(cat.url)
            .into(holder.catImage)

        holder.itemView.setOnClickListener {
            onItemClick(cat)
        }
    }
}




