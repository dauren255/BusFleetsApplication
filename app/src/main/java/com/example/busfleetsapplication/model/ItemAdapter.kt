package com.example.busfleetsapplication.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleetsapplication.R


class ItemAdapter(
    var itemList1: List<Model>,
    context: Context
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rowitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.itemImage.setImageResource(itemList1[position].image)
        holder.itemtxt.text = itemList1[position].name
    }

    override fun getItemCount(): Int {
        return itemList1.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemtxt: TextView
        var linearLayout: LinearLayout

        init {
            itemImage = itemView.findViewById(R.id.itemImg)
            itemtxt = itemView.findViewById(R.id.itemName)
            linearLayout = itemView.findViewById(R.id.layout_id)
        }
    }

    init {
        this.context = context
    }
}