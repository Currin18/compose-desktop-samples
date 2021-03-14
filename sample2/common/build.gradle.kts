import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm("desktop")
    sourceSets {
        named("commonMain") {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation("io.ktor:ktor-client-core:1.4.1")
            }
        }
        named("androidMain") {
            dependencies {
                api("androidx.appcompat:appcompat:1.3.0-beta01")
                api("androidx.core:core-ktx:1.3.2")
                implementation("io.ktor:ktor-client-cio:1.4.1")
            }
        }
        named("desktopMain") {
            dependencies {
                api(compose.desktop.common)
                implementation("io.ktor:ktor-client-cio:1.4.1")
            }
        }
    }
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_15
        targetCompatibility = JavaVersion.VERSION_15
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}