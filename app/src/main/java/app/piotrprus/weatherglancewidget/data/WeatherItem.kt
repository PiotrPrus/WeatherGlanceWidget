package app.piotrprus.weatherglancewidget.data

data class WeatherItem(
    val address: String? = null,
    val latitude: Double,
    val longitude: Double,
    val temperature: Int,
    val windSpeed: Int,
    val humidity: Int,
    val pressure: Int
)
