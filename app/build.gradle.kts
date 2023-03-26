import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

android {
    compileSdk = Versions.androidCompileSdk

    defaultConfig {
        applicationId = "app.piotrprus.weatherglancewidget"
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField(
            "String",
            "WEATHER_API_KEY",
            gradleLocalProperties(rootDir).getProperty("WEATHER_API_KEY") ?: ""
        )
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += setOf("META-INF/*.kotlin_module")
        }
    }
    namespace = "app.piotrprus.weatherglancewidget"
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(platform(Libs.AndroidX.Compose.bom))
    implementation(Libs.AndroidX.Compose.runtime)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.preview)
    implementation(Libs.AndroidX.Compose.icons)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.composeActivity)

    implementation(Libs.AndroidX.Glance.glance)
    implementation(Libs.AndroidX.Glance.appWidget)

    implementation(Libs.Koin.core)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.compose)
    implementation(Libs.Koin.workManager)

    implementation(Libs.AndroidX.Work.runtimeKtx)

    implementation(Libs.Ktor.android)
    implementation(Libs.Ktor.core)
    implementation(Libs.Ktor.json)
    implementation(Libs.Ktor.logging)
    implementation(Libs.Ktor.serialization)

    implementation(Libs.Kotlin.Serialization.core)
    implementation(Libs.Kotlin.Serialization.json)

    implementation(Libs.jodaTime)
    implementation(Libs.timber)
}