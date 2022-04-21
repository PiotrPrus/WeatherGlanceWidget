package app.piotrprus.weatherglancewidget.widget

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.state.getAppWidgetState
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import app.piotrprus.weatherglancewidget.data.WeatherRepository
import timber.log.Timber

class WeatherWidgetWorker(
    private val repository: WeatherRepository,
    private val appContext: Context,
    private val workerParameters: WorkerParameters
) : CoroutineWorker(appContext, workerParameters) {

    companion object {
        private const val WIDGET_LATITUDE_KEY = "widget_latitude_key"
        private const val WIDGET_LONGITUDE_KEY = "widget_longitude_key"

        fun buildData(latitude: Double, longitude: Double) = workDataOf(
            WIDGET_LATITUDE_KEY to latitude,
            WIDGET_LONGITUDE_KEY to longitude
        )
    }

    override suspend fun doWork(): Result {
        return getLocation()?.let { locationPair ->
            val glanceId = GlanceAppWidgetManager(appContext)
                .getGlanceIds(WeatherWidget::class.java).firstOrNull { id ->
                    WeatherWidget().getAppWidgetState<Preferences>(
                        appContext,
                        id
                    ).let { prefs ->
                        WidgetStateHelper.isStored(
                            prefs,
                            latitude = locationPair.first,
                            longitude = locationPair.second
                        )
                    }
                } ?: return Result.failure()
            updateWidgetState(glanceId) {
                WidgetStateHelper.setLoading(it, true)
            }
            repository.getData(latitude = locationPair.first, longitude = locationPair.second)
                .onSuccess { item ->
                    Timber.d("Success fetch weather data; $item")
                    updateWidgetState(glanceId) {
                        WidgetStateHelper.save(it, item)
                    }
                    return Result.success()
                }
                .onFailure { throwable ->
                    Timber.e(throwable, "Error fetching weather data")
                    updateWidgetState(glanceId) {
                        WidgetStateHelper.setLoading(it, false)
                    }
                    return Result.retry()
                }
            Result.success()
        } ?: Result.failure()
    }

    private suspend fun updateWidgetState(
        glanceId: GlanceId,
        update: (MutablePreferences) -> Unit
    ) {
        WeatherWidget().apply {
            updateAppWidgetState(appContext, glanceId) {
                update(it)
            }
            update(appContext, glanceId)
        }
    }

    private fun getLocation(): Pair<Double, Double>? {
        return inputData.let {
            it.getDouble(WIDGET_LATITUDE_KEY, Double.MIN_VALUE) to
                    it.getDouble(
                        WIDGET_LONGITUDE_KEY, Double.MIN_VALUE
                    )
        }.let { locationPair ->
            if (locationPair.first == Double.MIN_VALUE || locationPair.second == Double.MIN_VALUE) null
            else locationPair
        }
    }
}