package app.piotrprus.weatherglancewidget.data

import kotlin.math.roundToInt

class WeatherRepository(
    private val api: WeatherApi
) {
    suspend fun getData(latitude: Double, longitude: Double): Result<WeatherItem> =
        kotlin.runCatching {
            api.getData(latitude = latitude, longitude = longitude)
        }.mapCatching { response ->
            WeatherItem(
                latitude = latitude,
                longitude = longitude,
                temperature = (response.main.temp.minus(272.15)).roundToInt(),
                windSpeed = response.wind.speed.roundToInt(),
                humidity = response.main.humidity.roundToInt(),
                pressure = response.main.pressure.roundToInt()
            )
        }
}