package com.guide.alger.nabilsoft.carfaxassignment.ui.adapters

import android.content.IntentFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car
import com.guide.alger.nabilsoft.carfaxassignment.databinding.ItemCarBinding

class CarAdapter(var carslist : List<Car>) :RecyclerView.Adapter<CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding =ItemCarBinding.inflate(layoutInflater,parent,false)
        return CarViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
     holder.bind(carslist[position])
    }


    override fun getItemCount(): Int {
        return carslist.size
    }
}