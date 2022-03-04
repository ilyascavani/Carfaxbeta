package com.guide.alger.nabilsoft.carfaxassignment.utils

import androidx.room.TypeConverter
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Dealer
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Firstphoto
import com.guide.alger.nabilsoft.carfaxassignment.data.model.Image

class Converters {
    @TypeConverter
    fun fromimage(image : Image):String{
        return image.firstphoto.large
    }
    @TypeConverter
    fun toimage(url : String):Image{
        return Image(Firstphoto(url))
    }
    @TypeConverter
    fun fromdealer(dealer : Dealer):String{

        return dealer.city
    }
    @TypeConverter
    fun todealer (string : String ):Dealer{
        return Dealer(string,string,string)
    }
}