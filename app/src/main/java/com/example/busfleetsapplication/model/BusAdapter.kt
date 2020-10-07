package com.example.busfleetsapplication.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleetsapplication.R
import kotlinx.android.synthetic.main.rowitem.view.*

class BusAdapter(
    var itemList: List<Bus>,
    private val onItemClick: (Bus) -> Unit
) : RecyclerView.Adapter<BusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rowitem, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(itemList[position])
    }

    override fun getItemCount() = itemList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(bus: Bus){
            itemView.itemImg.setImageResource(itemList[position].image)
            itemView.itemName.text = bus.name
            itemView.itemBusName.text = bus.busName
            itemView.itemDeparture.text = "Отправление: " + bus.departure
            itemView.itemArrival.text = "Прибытие: " + bus.arrival

            itemView.setOnClickListener{
                onItemClick(bus)
            }
        }
    }
}