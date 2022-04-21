package app.piotrprus.weatherglancewidget

import android.app.Application
import androidx.work.Configuration
import app.piotrprus.weatherglancewidget.di.androidModule
import app.piotrprus.weatherglancewidget.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@WeatherApp)
            workManagerFactory()
            modules(
                networkModule,
                androidModule
            )
        }
    }

}