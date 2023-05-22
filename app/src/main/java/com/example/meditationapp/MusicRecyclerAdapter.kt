package com.example.meditationapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView

class MusicRecyclerAdapter : RecyclerView.Adapter<MusicRecyclerAdapter.ViewHolder>() {

    private var musicLabel =
        arrayOf("Guitar Song", "LoFi", "Piano Song", "Relax", "Relax2", "Guitar2")
    private var musicFull = arrayOf(
        R.raw.gitar,
        R.raw.lofi,
        R.raw.piano,
        R.raw.relaxing1,
        R.raw.relaxing2,
        R.raw.gitar2
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.music_recycler_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return musicLabel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemLabel.text = musicLabel[position]
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemLabel: TextView
        var itemContainer: LinearLayout

        init {
            itemLabel = itemView.findViewById(R.id.music_label)
            itemContainer = itemView.findViewById(R.id.music_container)


            itemContainer.setOnClickListener {
                var mf = MeditationFragment()
                mf.setNewMusic(musicFull[position])

                Toast.makeText(itemView.context,"Новый музыкальный фон",Toast.LENGTH_SHORT).show()
            }
        }
    }
}