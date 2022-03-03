package com.guide.alger.nabilsoft.carfaxassignment.data.remote


import com.guide.alger.nabilsoft.carfaxassignment.data.model.CarResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
@GET("/assignment.json")
//suspend fun getcarlist():Response<CarResponse>

 fun getcarlist(): Observable<Response<CarResponse>>
companion object{
    fun getInstance() = ApiClient.retrofit.create(ApiService::class.java)
}

}