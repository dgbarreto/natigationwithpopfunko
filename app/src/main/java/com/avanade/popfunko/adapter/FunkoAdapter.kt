package com.avanade.popfunko.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avanade.popfunko.R
import com.avanade.popfunko.model.Funko

class FunkoAdapter(private val context : Context, private val dataset : List<Funko>) : RecyclerView.Adapter<FunkoAdapter.FunkoViewHolder>() {
    class FunkoViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.imageFunko)
        val textView : TextView = view.findViewById(R.id.textFunko)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunkoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.funko_item, parent, false)

        return FunkoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FunkoViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView.text = item.name
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.count()
}