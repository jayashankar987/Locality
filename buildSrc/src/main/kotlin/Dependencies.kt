object BuildPlugins {
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"
    val android_gms_service = "com.google.gms:google-services:${Versions.gms}"
}


private object Versions {
    val gradle = "3.3.2"
    val kotlin = "1.3.21"
    val support_appcompat = "26.1.0"

    val gms = "4.2.0"
    val firebase_core = "16.0.1"
    val firebase_auth = "16.2.0"
    val jannotation = "1.0"

    val dagger = "2.9"
    val reactiveXJava = "2.1.10"
    val reactiveXAndroid = "2.0.2"
    val timber = "4.7.0"

    val retrofitVersion = "2.4.0"
}

object Deps {

    val androidVersion = object {
        val minSdk = 16
        val targetSdk = 28
        val compileSdk = 28
        val versionCode = 1
        val versionName = "1.0"
    }

    val gms_services = "com.google.gms.google-services"
    val jannotation = "javax.annotation:jsr250-api:${Versions.jannotation}"

    //Kotlin Libraries
    val kotlin = object {
        val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    ///Android Support Libraries
    val support = object {
        val appcompact = "com.android.support:appcompat-v7:${Versions.support_appcompat}"
    }

    //Firebase
    val firebase = object {
        val core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
        val auth  = "com.google.firebase:firebase-auth:${Versions.firebase_auth}"
    }

    //Dagger
    val dagger = object {
        val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    }

    //RxJava
    val reactiveX = object {
        val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.reactiveXJava}"
        val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.reactiveXAndroid}"
    }

    //timber
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Retrofit
    val retrofit = object {
        val retrofitCore = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    }

}