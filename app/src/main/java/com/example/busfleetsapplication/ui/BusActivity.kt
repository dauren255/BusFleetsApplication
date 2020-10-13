package com.example.busfleetsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.*
import kotlinx.android.synthetic.main.activity_bus.*
import com.google.android.material.bottomsheet.BottomSheetDialog;


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
        val data = intent.getParcelableExtra<Bus> (EXTRA_DATA)
        takenPlacesRecyclerView.layoutManager = LinearLayoutManager(this)
        freePlacesRecyclerView.layoutManager = LinearLayoutManager(this)

        if (data?.busName == "YUTONG1") {
            freePlacesRecyclerView.adapter = PlaceAdapter(data.getFreePlaces(), onItemClick = {})
            takenPlacesRecyclerView.adapter = PlaceAdapter(data.getTakenPlaces(), onItemClick = {
                val dialog = BottomSheetDialog(this)
                val view = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
                val name = view.findViewById<EditText>(R.id.sheetClientName)
                val phone = view.findViewById<EditText>(R.id.sheetClientPhone)
                val email = view.findViewById<EditText>(R.id.sheetClientEmail)
                val placeName = view.findViewById<EditText>(R.id.sheetClientPlace)
                val price = view.findViewById<EditText>(R.id.sheetClientPlacePrice)
                name.setText(it.placeClient?.clientName)
                phone.setText(it.placeClient?.clientPhone)
                placeName.setEnabled(false)
                placeName.setText(it.placeName)
                price.setText(it.placePrice.toString())
                val saveButton = view.findViewById<Button>(R.id.sheetSaveButton)
                val deleteButton = view.findViewById<Button>(R.id.sheetDeleteButton)
                saveButton.setOnClickListener(View.OnClickListener { view ->
                    it.setClient(Client(name.text.toString(),phone.text.toString(), Type.ONLINE))
                    dialog.dismiss()
                    finish();
                    startActivity(getIntent());
                })
                deleteButton.setOnClickListener(View.OnClickListener { view ->
                    it.deleteClient()
                    dialog.dismiss()
                    finish();
                    startActivity(getIntent());
                })
                dialog.setContentView(view)
                dialog.show()
            })

        }
    }
}


