package com.example.busfleetsapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Bus (val image: Int,
           val busName: String,
           val name: String,
           val departure: String,
           val arrival: String,
            val places: MutableList<Place>
): Parcelable {
    fun setClientToPlace(placeName: String, placeClient: Client){
        for(place in this.places){
            if(place.placeName==placeName && place.placeClient ==  null){
                place.setClient(placeClient)
                break
            } else if(place.placeName==placeName && place.placeClient !=  null){
                print("Place is not free")
            }
        }
    }
    fun addPlaces(placeName: String, placePrice: Double){
        places.add(Place(placeName, placePrice, null))
    }
    fun getTakenPlaces(): MutableList<Place> {
        val taken: MutableList<Place> = mutableListOf<Place>()
        for(place in this.places) {
            if(place.placeClient != null) taken.add(place)
        }
        taken.shuffle()
        return taken
    }
    fun getFreePlaces(): MutableList<Place> {
        val free: MutableList<Place> = mutableListOf<Place>()
        for(place in this.places) {
            if(place.placeClient == null) free.add(place)

        }
        return free
    }
}