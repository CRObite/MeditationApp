package com.example.meditationapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var images = arrayOf(R.drawable.persone1,R.drawable.persone2,R.drawable.persone3,R.drawable.persone4,R.drawable.persone5,R.drawable.persone6,R.drawable.persone7,R.drawable.persone8,R.drawable.persone9,R.drawable.persone10)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemImage.setImageResource(images[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.persone_img)


            itemImage.setOnClickListener {
                val intent = Intent(itemView.context, CoreMedPage::class.java)
                intent.putExtra("persone", images[position])
                itemView.context.startActivity(intent)
            }
        }
    }
}