object Versions {
    const val kotlin = "1.8.10"
    const val androidMinSdk = 23
    const val androidCompileSdk = 33
    const val androidTargetSdk = androidCompileSdk
    const val compose = "1.1.1"
}

object Libs {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val jodaTime = "joda-time:joda-time:2.10.10"

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

    object AndroidX {
        const val composeActivity = "androidx.activity:activity-compose:1.4.0"

        object Lifecycle {
            private const val version = "2.4.0-alpha01"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Work {
            private const val version = "2.7.1"
            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }

        object Compose {
            const val bom = "androidx.compose:compose-bom:2023.01.00"

            const val runtime = "androidx.compose.runtime:runtime"

            const val material = "androidx.compose.material:material"
            const val icons = "androidx.compose.material:material-icons-extended"

            const val preview = "androidx.compose.ui:ui-tooling-preview"
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
