package com.example.busfleetsapplication.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleetsapplication.R
import kotlinx.android.synthetic.main.placesitem.view.*

class PlaceAdapter(
    var places: List<Place>
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.placesitem, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(places[position])
    }

    override fun getItemCount() = places.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(place: Place){
            itemView.clientName.text = place.name
            itemView.clientPlace.text = place.place
            itemView.clientType.text = place.type
        }
    }
}