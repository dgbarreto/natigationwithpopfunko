package com.avanade.popfunko.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.avanade.popfunko.R

class CollectionAdapter(private val context: Context, private val dataset: List<String>) : RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>() {
    class CollectionViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.buttonCollection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.collection_item, parent, false)

        return CollectionViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
    }

    override fun getItemCount() = dataset.count()
}