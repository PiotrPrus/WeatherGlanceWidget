package app.piotrprus.weatherglancewidget.data

import io.ktor.client.*
import io.ktor.client.request.*

class WeatherApi(private val httpClient: HttpClient) {
    suspend fun getData(latitude: Double, longitude: Double): WeatherResponse =
        httpClient.get {
            url {
                encodedPath = "weather"
                parameter("lat", latitude)
                parameter("lon", longitude)
            }
        }
}
