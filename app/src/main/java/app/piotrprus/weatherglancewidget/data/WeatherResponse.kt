package app.piotrprus.weatherglancewidget.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val main: WeatherMain,
    val wind: WindResponse
)

@Serializable
data class WeatherMain(
    val temp: Double,
    @SerialName("feels_like") val feelsLike: Double,
    @SerialName("temp_min") val tempMin: Double,
    @SerialName("temp_max") val tempMax: Double,
    val pressure: Double,
    val humidity: Double,
)

@Serializable
data class WindResponse(
    val speed: Double,
    val deg: Int,
    val gust: Double? = null
)
