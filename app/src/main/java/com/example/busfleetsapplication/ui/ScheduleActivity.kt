package com.example.busfleetsapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.*
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setupViews()
    }

    private fun setupViews(){
        scheduleRecyclerView.layoutManager = LinearLayoutManager(this)

        val places = mutableListOf(
            Place("A1", 3000.0, null),
            Place("A2", 3000.0, null),
            Place("A3", 3000.0, null),
            Place("A4", 3000.0, null),
            Place("A5", 3000.0, null),
            Place("A6", 3000.0, null)
            )
        val buses = mutableListOf(
            Bus(R.drawable.ic_bus,"YUTONG1", "Алматы-Семей", "16:30", "20:30", places),
            Bus(R.drawable.ic_bus,"YUTONG2", "Алматы-Тараз", "16:30", "20:30", places),
            Bus(R.drawable.ic_bus,"YUTONG3", "Алматы-Караганда", "16:30", "20:30", places)
        )
        
        buses[1].setClientToPlace("A1", Client("Aigerim", "87473423121", Type.ONLINE))
        buses[1].setClientToPlace("A2", Client("Gani", "87473423121", Type.ONLINE))
        buses[1].setClientToPlace("A3", Client("Aruzhan", "87473423121", Type.ONLINE))
        scheduleRecyclerView.adapter = BusAdapter(itemList = buses,
            onItemClick = {
                val intent = Intent(this, BusActivity::class.java)
                intent.putExtra(BusActivity.EXTRA_DATA, it)
                startActivity(intent)
            })
    }
}