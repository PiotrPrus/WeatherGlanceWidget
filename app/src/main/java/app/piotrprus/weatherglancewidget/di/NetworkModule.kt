package app.piotrprus.weatherglancewidget.di

import app.piotrprus.weatherglancewidget.BuildConfig
import app.piotrprus.weatherglancewidget.data.WeatherApi
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.dsl.module
import timber.log.Timber

val networkModule = module {
    single<Logger> {
        val tag = "HttpClient"
        val logger = object : Logger {
            override fun log(message: String) {
                Timber.i(tag, message)
            }
        }
        MessageLengthLimitingLogger(delegate = logger)
    }
    single { createHttpClient(get()) }
    single { WeatherApi(get()) }
}

fun createHttpClient(logger: Logger) =
    HttpClient(Android) {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = "api.openweathermap.org/data/2.5"
            parameter("appid", BuildConfig.WEATHER_API_KEY)
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }
        install(Logging) {
            this.logger = logger
            level = LogLevel.INFO
        }
    }