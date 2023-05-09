plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
            export("dev.icerock.moko:resources:0.22.0")
            export("dev.icerock.moko:graphics:0.9.0") // toUIColor here
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("dev.icerock.moko:resources:0.22.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.wonddak.mokoresources"
    compileSdk = 33
    defaultConfig {
        minSdk = 30
    }
}

multiplatformResources {
    // (필수) 반드시 입력
    multiplatformResourcesPackage = "com.wonddak.mokoresources"
    // (선택) 기본값 MR
    multiplatformResourcesClassName = "SharedRes"
    // (선택) 기본값 Public
//    multiplatformResourcesVisibility = MRVisibility.Internal
    // (선택) 기본값 en
    iosBaseLocalizationRegion = "ko"
    // (선택) 기본값 "commonMain"
//    multiplatformResourcesSourceSet = "commonClientMain"
}