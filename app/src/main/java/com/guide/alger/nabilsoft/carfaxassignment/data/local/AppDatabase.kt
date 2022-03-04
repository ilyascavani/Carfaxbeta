package com.guide.alger.nabilsoft.carfaxassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car
import com.guide.alger.nabilsoft.carfaxassignment.utils.Converters

@Database(entities = [Car::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
abstract fun CarDao():CarDao

companion object{
    private var INSTANCE :  AppDatabase? =null
    fun getINSTANCE(context: Context) : AppDatabase {
        if (INSTANCE == null){
            synchronized (AppDatabase::class){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "CarDB"
                ).build()
            }
        }
        return INSTANCE as AppDatabase
    }
    fun cleardatabase(){
        INSTANCE=null
    }
}
}