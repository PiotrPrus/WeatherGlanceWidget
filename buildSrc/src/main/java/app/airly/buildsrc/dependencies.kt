object Versions {
    const val kotlin = "1.6.10"
    const val androidMinSdk = 23
    const val androidCompileSdk = 33
    const val androidTargetSdk = androidCompileSdk
    const val compose = "1.1.1"
}

object Libs {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val jodaTime = "joda-time:joda-time:2.10.10"

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:29.0.4"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val inAppMess = "com.google.firebase:firebase-inappmessaging-display-ktx"
        const val remoteConfig = "com.google.firebase:firebase-config-ktx"
        const val dynamicLinks = "com.google.firebase:firebase-dynamic-links-ktx"
        const val perf = "com.google.firebase:firebase-perf-ktx"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
        const val auth = "com.google.firebase:firebase-auth-ktx"
        const val database = "com.google.firebase:firebase-database-ktx"
        const val storage = "com.google.firebase:firebase-storage-ktx"
    }

    object Google {
        const val auth = "com.google.android.gms:play-services-auth:20.1.0"
        const val location = "com.google.android.gms:play-services-location:19.0.1"
        const val gmsGoogleServices = "com.google.gms:google-services:4.3.10"
        const val openSourceLicensesPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.4"
        const val openSourceLicensesLibrary =
            "com.google.android.gms:play-services-oss-licenses:17.0.0"
        const val playCoreKtx = "com.google.android.play:core-ktx:1.8.1"
        const val qrScan = "com.google.zxing:core:3.4.1"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"

        object Serialization {
            private const val version = "1.2.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object Coroutines {
        private const val version = "1.5.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val playServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$version"
        const val rx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
    }

    object AndroidX {
        const val composeActivity = "androidx.activity:activity-compose:1.4.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val browser = "androidx.browser:browser:1.0.0"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val palette = "androidx.palette:palette:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha06"
        const val emoji = "androidx.emoji:emoji:1.1.0"
        const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        object DataStore {
            private const val version = "1.0.0"
            const val preferences = "androidx.datastore:datastore-preferences:$version"
            const val core = "androidx.datastore:datastore-core:$version"
        }

        object Navigation {
            private const val version = "2.4.1"
            const val compose = "androidx.navigation:navigation-compose:$version"
        }

        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Lifecycle {
            private const val version = "2.4.0-alpha01"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Work {
            private const val version = "2.7.1"
            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }

        object Compose {
            const val compiler = "androidx.compose.compiler:compiler:${Versions.compose}"

            const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
            const val livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"

            const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
            const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"

            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val icons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0"

            const val animation = "androidx.compose.animation:animation:${Versions.compose}"

            const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
            const val test = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        }

        object Glance {
            private const val version = "1.0.0-alpha05"
            const val glance = "androidx.glance:glance:$version"
            const val appWidget = "androidx.glance:glance-appwidget:$version"
        }
    }

    object Ktor {
        private const val version = "1.6.4"
        const val android = "io.ktor:ktor-client-android:$version"
        const val core = "io.ktor:ktor-client-core:${version}"
        const val json = "io.ktor:ktor-client-json:${version}"
        const val logging = "io.ktor:ktor-client-logging:${version}"
        const val serialization = "io.ktor:ktor-client-serialization:${version}"
    }

    object Koin {
        private const val version = "3.1.6"
        const val core = "io.insert-koin:koin-core:${version}"
        const val android = "io.insert-koin:koin-android:${version}"
        const val compose = "io.insert-koin:koin-androidx-compose:${version}"
        const val workManager = "io.insert-koin:koin-androidx-workmanager:${version}"
    }
}
