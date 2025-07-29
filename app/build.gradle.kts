plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.dagger.hilt)
}


android {
    namespace = "com.example.restoapps"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.restoapps"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.androidx.core.ktx)
    implementation(project(":core"))
    implementation(libs.androidx.multidex)

    // Dagger-hilt
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // Coroutine
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.play.services)

    // Reactive Component
    api(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.runtime.livedata)

    // Navigation
    implementation(libs.androidx.navigation)

    // UI
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.google.accompanist)
    implementation(libs.io.coil.compose)
    implementation(libs.bumptech.glide.compose)

    //Logger
    implementation(libs.jakewharton.timber)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}