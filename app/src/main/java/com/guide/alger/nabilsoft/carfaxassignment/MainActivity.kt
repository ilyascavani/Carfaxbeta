package com.guide.alger.nabilsoft.carfaxassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.guide.alger.nabilsoft.carfaxassignment.data.remote.ApiService
import com.guide.alger.nabilsoft.carfaxassignment.data.repositry.CarRepositry
import com.guide.alger.nabilsoft.carfaxassignment.databinding.ActivityMainBinding
import com.guide.alger.nabilsoft.carfaxassignment.ui.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val api =ApiService.getInstance()
        val repositry=CarRepositry(applicationContext,api)
        val viewmodel= ViewModelProvider(this)[CarViewModel::class.java]


    }
}