package com.example.busfleetsapplication.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleetsapplication.R
import kotlinx.android.synthetic.main.placesitem.view.*

class PlaceAdapter(
    var places: List<Place>,
    private val onItemClick: (Place) -> Unit

) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.placesitem, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(places[position])
    }

    override fun getItemCount() = places.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(place: Place){
            if(place.placeClient == null) {
                itemView.clientName.text = "Нет имени"
                itemView.clientPlace.text = place.placeName
                itemView.clientType.text = "Нет типа"
            } else {
                itemView.clientName.text = place.placeClient?.clientName
                itemView.clientPlace.text = place.placeName
                itemView.clientType.text = place.placeClient?.clientType?.name
            }
            itemView.setOnClickListener{
                onItemClick(place)
            }
        }
    }
}