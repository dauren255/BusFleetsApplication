package com.example.busfleetsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.ItemAdapter
import com.example.busfleetsapplication.model.Model
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setupViews()
    }

    private fun setupViews(){
        scheduleRecyclerView.layoutManager = LinearLayoutManager(this)

        val buses = mutableListOf(
            Model(R.drawable.ic_bus,"YUTONG", "Алматы-Семей", "16:30", "20:30"),
            Model(R.drawable.ic_bus,"YUTONG", "Алматы-Тараз", "16:30", "20:30"),
            Model(R.drawable.ic_bus,"YUTONG", "Алматы-Караганда", "16:30", "20:30")
        )
        scheduleRecyclerView.adapter = ItemAdapter(itemList = buses,
            onItemClick = {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            })
    }
}