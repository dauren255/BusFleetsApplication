package com.example.busfleetsapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.BusAdapter
import com.example.busfleetsapplication.model.Bus
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.rowitem.*

class ScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setupViews()
    }

    private fun setupViews(){
        scheduleRecyclerView.layoutManager = LinearLayoutManager(this)

        val buses = mutableListOf(
            Bus(R.drawable.ic_bus,"YUTONG1", "Алматы-Семей", "16:30", "20:30"),
            Bus(R.drawable.ic_bus,"YUTONG2", "Алматы-Тараз", "16:30", "20:30"),
            Bus(R.drawable.ic_bus,"YUTONG3", "Алматы-Караганда", "16:30", "20:30")
        )
        scheduleRecyclerView.adapter = BusAdapter(itemList = buses,
            onItemClick = {
                val intent = Intent(this, BusActivity::class.java)
                intent.putExtra(BusActivity.EXTRA_DATA, it.busName)
                startActivity(intent)
            })
    }
}