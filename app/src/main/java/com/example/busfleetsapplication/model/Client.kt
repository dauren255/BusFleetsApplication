package com.example.busfleetsapplication.model

import android.os.Parcelable
import android.text.Editable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Client(var clientName: String, var clientPhone: String, var clientType: Type) :Parcelable{

    fun setName(clientName: String){
        this.clientName = clientName
    }
}