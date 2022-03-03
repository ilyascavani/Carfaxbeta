package com.guide.alger.nabilsoft.carfaxassignment.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guide.alger.nabilsoft.carfaxassignment.data.model.CarResponse
import com.guide.alger.nabilsoft.carfaxassignment.data.repositry.CarRepositry

class CarViewModel(private val repositry : CarRepositry) : ViewModel () {
   var carlist : MutableLiveData <CarResponse> = MutableLiveData()
   fun getcarlist() : MutableLiveData<CarResponse>{
      return carlist
   }
fun getcars() {
  var list = repositry.getAllCars()

}
   fun fetchcars():MutableLiveData<CarResponse>{
     return repositry.getcarresponse()
   }

}