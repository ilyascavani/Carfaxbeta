package com.guide.alger.nabilsoft.carfaxassignment.data.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="car_table")
data class Car(

    @PrimaryKey
    @ColumnInfo
    val id: String,

    @ColumnInfo
    @Nullable
    val currentPrice: String,

    @ColumnInfo
    @Nullable
    val make: String,

    @ColumnInfo
    @Nullable
    val mileage: String,

    @ColumnInfo
    @Nullable
    val model: String,

    @ColumnInfo
    @Nullable
    val trim: String,

    @ColumnInfo
    @Nullable
    val year: String,

    @ColumnInfo
    @Nullable
    val images: Image? = null,

    @ColumnInfo
    @Nullable
    val interiorColor: String,

    @ColumnInfo
    @Nullable
    val exteriorColor: String,

    @ColumnInfo
    @Nullable
    val bodytype: String,

    @ColumnInfo
    @Nullable
    val drivetype: String,

    @ColumnInfo
    @Nullable
    val engine: String,

    @ColumnInfo
    @Nullable
    val fuel: String,

    @ColumnInfo
    @Nullable
    val transmission: String,

    @ColumnInfo
    @Nullable
    val dealer: Dealer? = null
):Serializable
data class Image(val firstphoto : Firstphoto) : Serializable
data class Firstphoto(val large : String):Serializable
data class Dealer(
    val phone: String,
    val city: String,
    val state: String
): Serializable
