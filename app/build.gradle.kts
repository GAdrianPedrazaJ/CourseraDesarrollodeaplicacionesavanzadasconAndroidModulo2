plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.petagram"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.petagram"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Retrofit para conexión a APIs
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

// Conversor Gson (para interpretar respuestas JSON)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Librería adicional para ver logs de red (opcional pero útil)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.squareup.picasso:picasso:2.8")
}