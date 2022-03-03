package com.guide.alger.nabilsoft.carfaxassignment.data.repositry

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.guide.alger.nabilsoft.carfaxassignment.data.local.AppDatabase
import com.guide.alger.nabilsoft.carfaxassignment.data.local.CarDao
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car
import com.guide.alger.nabilsoft.carfaxassignment.data.model.CarResponse
import com.guide.alger.nabilsoft.carfaxassignment.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


import io.reactivex.schedulers.Schedulers

class CarRepositry (private val context: Context, val api : ApiService ){
    lateinit var carDao: CarDao
    init {
         val db=AppDatabase.getINSTANCE(context.applicationContext)
        carDao =db.CarDao()
    }

    //Get the cars list from DB
    fun getAllCars () = carDao.getcars()

    //Insert a car in the DB
    fun insertcar( car : Car){
        carDao.insertcar(car)
    }
    // will store the data received from the api request in carespons
    private var carespons=MutableLiveData<CarResponse>()
    var compositeDisposable:CompositeDisposable= CompositeDisposable()
    fun getcarresponse():MutableLiveData<CarResponse>{
        compositeDisposable.add( api.getcarlist().
        subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe {
            if(it.isSuccessful && it != null){
                carespons.postValue(it.body())
            }
            else{
                // do any thing here
            }
        })
      return carespons
    }

}