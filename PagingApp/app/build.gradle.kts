@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.pagingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pagingapp"
        minSdk = 34
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    // to use GsonConverterFactory.create() in Retrofit.Builder().addConverterFactory
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // rxjava3 with retrofit
    // to use RxJava3CallAdapterFactory.create() in Retrofit.Builder().addCallAdapterFactory
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

    // paging
    val paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")
    // optional - RxJava3 support
    implementation("androidx.paging:paging-rxjava3:$paging_version")

    // hilt dagger
    implementation("com.google.dagger:hilt-android:2.48.1")
    annotationProcessor("com.google.dagger:hilt-compiler:2.48.1")

    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // lifecycle
    val lifecycle_version = "2.6.2"
    val arch_version = "2.2.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
}