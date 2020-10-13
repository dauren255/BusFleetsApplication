package com.example.busfleetsapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Place(val placeName: String, val placePrice: Double, var placeClient: Client?) : Parcelable {

    fun setClient(placeClient: Client?){
        this.placeClient = placeClient
    }
    fun deleteClient(){
        this.placeClient = null
    }
}