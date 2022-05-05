package com.example.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.model.Location
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.Repository

class WeatherViewModel:ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    //这几个变量用来缓存，防止当屏幕旋转时数据丢失
    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    //用switchMap来观察有refreshWeather得到的locationLiveData对象，在switchMap中调用仓库层定义的refreshWeather
    //仓库层返回的LiveData对象就可以转化成一个可供Activity观察的LiveData对象了
    val weatherLiveData = Transformations.switchMap(locationLiveData) {
        location -> Repository.refreshWeather(location.lng,location.lat)
    }

    fun refreshWeather(lng: String, lat: String){
        locationLiveData.value = Location(lng,lat)
    }


}