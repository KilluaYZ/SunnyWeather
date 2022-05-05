package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

//这样做可以让GSON直接将json解析成为一个对象
data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: Realtime)

    data class Realtime(val skycon: String, val temperature: Float,
    @SerializedName("air_quality") val airQuality: AirQuality)

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}