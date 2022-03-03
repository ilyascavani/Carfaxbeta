package com.guide.alger.nabilsoft.carfaxassignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car


@Dao
interface CarDao {
    @Query("SELECT * FROM car_table")
    fun getcars() : List<Car>
    @Insert
    fun insertcar(car : Car)
}