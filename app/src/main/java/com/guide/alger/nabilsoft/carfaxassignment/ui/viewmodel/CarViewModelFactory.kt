package com.guide.alger.nabilsoft.carfaxassignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guide.alger.nabilsoft.carfaxassignment.data.repositry.CarRepositry

class CarViewModelFactory (private val repositry: CarRepositry):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return CarViewModel(repositry) as T
    }
}