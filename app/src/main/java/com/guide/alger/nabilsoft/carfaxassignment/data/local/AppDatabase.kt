package com.guide.alger.nabilsoft.carfaxassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Car

@Database(entities = [Car::class], version = 1)
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