plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.example.core"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles( "consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            multiDexEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        compose = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.androidx.multidex)

    // Dagger-hilt
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // Database
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    testImplementation(libs.androidx.room.testing)

    // Coroutine
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.play.services)

    // Lifecycle
    api(libs.androidx.lifecycle.livedata.ktx)

    // Logger
    implementation(libs.jakewharton.timber)
}