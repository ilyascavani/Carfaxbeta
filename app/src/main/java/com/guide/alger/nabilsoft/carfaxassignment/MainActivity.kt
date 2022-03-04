package com.guide.alger.nabilsoft.carfaxassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guide.alger.nabilsoft.carfaxassignment.data.model.CarResponse
import com.guide.alger.nabilsoft.carfaxassignment.data.remote.ApiService
import com.guide.alger.nabilsoft.carfaxassignment.data.repositry.CarRepositry
import com.guide.alger.nabilsoft.carfaxassignment.databinding.ActivityMainBinding
import com.guide.alger.nabilsoft.carfaxassignment.ui.adapters.CarAdapter
import com.guide.alger.nabilsoft.carfaxassignment.ui.viewmodel.CarViewModel
import com.guide.alger.nabilsoft.carfaxassignment.ui.viewmodel.CarViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val api =ApiService.getInstance()
        val repositry=CarRepositry(applicationContext,api)

      //  val viewmodel= ViewModelProvider(this)[CarViewModel::class.java]
        val viewmodel= ViewModelProvider(this,CarViewModelFactory(repositry))[CarViewModel::class.java]
      var list =  viewmodel.fetchcars()

        viewmodel.carlist.observe(this, Observer {
            initadapter(it)
        })
    }
    fun initadapter (cars : CarResponse){
        binding.apply {
            rvCar.layoutManager=LinearLayoutManager(this@MainActivity)
            rvCar.setHasFixedSize(true)
            rvCar.adapter=CarAdapter(cars.listings)
        }

    }
}