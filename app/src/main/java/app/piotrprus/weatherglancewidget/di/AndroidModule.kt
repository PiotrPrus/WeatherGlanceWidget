package app.piotrprus.weatherglancewidget.di

import app.piotrprus.weatherglancewidget.data.WeatherRepository
import app.piotrprus.weatherglancewidget.widget.WeatherWidgetWorker
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val androidModule = module {
    single { WeatherRepository(get()) }
    worker { WeatherWidgetWorker(get(), androidContext(), it.get()) }
}