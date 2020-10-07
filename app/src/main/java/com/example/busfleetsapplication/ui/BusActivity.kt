package com.example.busfleetsapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.Bus
import com.example.busfleetsapplication.model.BusAdapter
import com.example.busfleetsapplication.model.Place
import com.example.busfleetsapplication.model.PlaceAdapter
import kotlinx.android.synthetic.main.activity_bus.*
import kotlinx.android.synthetic.main.activity_schedule.*


class BusActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)
        setupViews()
    }

    private fun setupViews() {
        val data = intent.getStringExtra(EXTRA_DATA)
        takenPlacesRecyclerView.layoutManager = LinearLayoutManager(this)
        freePlacesRecyclerView.layoutManager = LinearLayoutManager(this)
        if (data == "YUTONG1") {
            val takens = mutableListOf(
                Place("Aigerim", "1A", "ONLINE"),
                Place("Dias", "2A", "ONLINE"),
                Place("Assel", "3A", "ONLINE")

            )
            val frees = mutableListOf(
                Place("No name", "1A", "No type"),
                Place("No name", "2A", "No type"),
                Place("No name", "3A", "No type")
            )
            takenPlacesRecyclerView.adapter = PlaceAdapter(places = takens)
            freePlacesRecyclerView.adapter = PlaceAdapter(places = frees)
        } else if (data == "YUTONG2") {
            val takens = mutableListOf(
                Place("Aigerim", "1A", "ONLINE"),
                Place("Dias", "2A", "ONLINE")

            )
            takenPlacesRecyclerView.adapter = PlaceAdapter(places = takens)

            val frees = mutableListOf(
                Place("No name", "1A", "No type"),
                Place("No name", "2A", "No type"),
                Place("No name", "3A", "No type"),
                Place("No name", "3A", "No type")


            )
            freePlacesRecyclerView.adapter = PlaceAdapter(places = frees)
        } else if (data == "YUTONG3") {
            val takens = mutableListOf(
                Place("Aigerim", "1A", "ONLINE")
            )
            takenPlacesRecyclerView.adapter = PlaceAdapter(places = takens)

            val frees = mutableListOf(
                Place("No name", "1A", "No type"),
                Place("No name", "2A", "No type"),
                Place("No name", "3A", "No type"),
                Place("No name", "2A", "No type"),
                Place("No name", "3A", "No type")

            )
            freePlacesRecyclerView.adapter = PlaceAdapter(places = frees)
        }
    }
}