package com.guide.alger.nabilsoft.carfaxassignment.ui.adapters

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.guide.alger.nabilsoft.carfaxassignment.R
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car
import com.guide.alger.nabilsoft.carfaxassignment.databinding.ItemCarBinding
import com.squareup.picasso.Picasso

class CarViewHolder (val  binding: ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(car : Car){
        binding.cartitles.text="${car.year}  ${car.make}  ${car.model}  ${car.trim} "
        Picasso.get().load("${car.images?.firstphoto?.large}").fit().placeholder(R.drawable.ic_baseline_directions_car_24).into(binding.CarimageView)
    }
}
