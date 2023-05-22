package com.example.meditationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<MusicRecyclerAdapter.ViewHolder>? = null
    private lateinit var musicRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_music, container, false)

        layoutManager = LinearLayoutManager(view.context)
        musicRecyclerView = view.findViewById(R.id.music_recycler_view)
        musicRecyclerView.layoutManager = layoutManager

        adapter = MusicRecyclerAdapter()

        musicRecyclerView.adapter = adapter

        return view
    }





}