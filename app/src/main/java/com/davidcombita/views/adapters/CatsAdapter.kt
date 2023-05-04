package com.davidcombita.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidcombita.R
import com.davidcombita.data.models.Cat
import com.squareup.picasso.Picasso

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>() {

    private lateinit var catsInfo: List<Cat>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cats, parent, false))
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.origen.text = catsInfo[position].origin
        holder.inteligencia.text = "Inteligencia: ${catsInfo[position].intelligence}"
        Picasso.get()
            .load("https://cdn2.thecatapi.com/images/"+catsInfo[position].referenceImageID+".jpg")
            .error(R.drawable.ic_launcher_background)
            .fit()
            .into(holder.image)
    }

    override fun getItemCount(): Int = catsInfo.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(catsInfo:List<Cat>){
        this.catsInfo = catsInfo
        notifyDataSetChanged()
    }
}

class CatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var origen: TextView = itemView.findViewById(R.id.textView_country)
    var inteligencia: TextView = itemView.findViewById(R.id.textView_smart)
    var image: ImageView = itemView.findViewById(R.id.imageView)
}