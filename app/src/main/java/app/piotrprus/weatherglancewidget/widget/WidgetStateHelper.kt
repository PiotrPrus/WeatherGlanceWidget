package app.piotrprus.weatherglancewidget.widget

import androidx.datastore.preferences.core.*
import app.piotrprus.weatherglancewidget.data.WeatherItem

object WidgetStateHelper {
    fun save(prefs: MutablePreferences, state: WeatherItem) {
        prefs[doublePreferencesKey(widgetLatitudeKey)] = state.latitude
        prefs[doublePreferencesKey(widgetLongitudeKey)] = state.longitude
        prefs[intPreferencesKey(widgetTemperatureKey)] = state.temperature
        prefs[intPreferencesKey(widgetHumidityKey)] = state.humidity
        prefs[intPreferencesKey(widgetWindKey)] = state.windSpeed
        prefs[booleanPreferencesKey(widgetLoadingKey)] = false
    }

    fun saveAddress(prefs: MutablePreferences, address: String) {
        prefs[stringPreferencesKey(widgetAddressKey)] = address
    }

    fun saveLocation(prefs: MutablePreferences, latitude: Double, longitude: Double) {
        prefs[doublePreferencesKey(widgetLatitudeKey)] = latitude
        prefs[doublePreferencesKey(widgetLongitudeKey)] = longitude
    }

    fun isStored(prefs: Preferences, latitude: Double, longitude: Double): Boolean =
        prefs[doublePreferencesKey(widgetLatitudeKey)] == latitude && prefs[doublePreferencesKey(
            widgetLongitudeKey
        )] == longitude

    fun setLoading(prefs: MutablePreferences, loading: Boolean) {
        prefs[booleanPreferencesKey(widgetLoadingKey)] = loading
    }

    fun getState(prefs: Preferences): WidgetState {
        val address = prefs[stringPreferencesKey(widgetAddressKey)] ?: ""
        val latitude = prefs[doublePreferencesKey(widgetLatitudeKey)] ?: Double.MIN_VALUE
        val longitude = prefs[doublePreferencesKey(widgetLongitudeKey)] ?: Double.MIN_VALUE
        val temperature = prefs[intPreferencesKey(widgetTemperatureKey)] ?: Int.MIN_VALUE
        val humidity = prefs[intPreferencesKey(widgetHumidityKey)] ?: Int.MIN_VALUE
        val wind = prefs[intPreferencesKey(widgetWindKey)] ?: Int.MIN_VALUE
        val loading = prefs[booleanPreferencesKey(widgetLoadingKey)] ?: false
        return WidgetState(
            data = WeatherItem(
                address = address,
                latitude = latitude,
                longitude = longitude,
                temperature = temperature,
                windSpeed = wind,
                humidity = humidity,
                pressure = 0
            ), loading = loading
        )
    }

    private const val widgetTemperatureKey = "widgetTemperatureKey"
    private const val widgetAddressKey = "widgetNameKey"
    private const val widgetLatitudeKey = "widgetLatitudeKey"
    private const val widgetLongitudeKey = "widgetLongitudeKey"
    private const val widgetLoadingKey = "widgetRefreshingKey"
    private const val widgetWindKey = "widgetWindKey"
    private const val widgetHumidityKey = "widgetHumidityKey"
}

data class WidgetState(
    val data: WeatherItem,
    val loading: Boolean,
)