object Versions {
    val app_version_code = 1
    val app_version_name = "1.0"

    val kotlin = "1.3.72"
    val kotlin_coroutines = "1.3.7"

    val build_minSdk = 23
    val build_compileSdk = 29
    val build_targetSdk = 29
    val build_buildTools = "28.0.3"

    val android_gradle_plugin = "3.6.3"

    val android_x_appcompat = "1.1.0"
    val android_x_core = "1.3.0"
    val android_x_constraintlayout = "1.1.3"
    val android_x_legacy_support = "1.0.0"
    val android_x_navigation = "2.2.0"
    val android_x_lifecycle = "2.2.0"
    val android_x_security = "1.0.0-rc02"
    val google_material = "1.1.0-alpha09"

}

object Deps {
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val safe_args_gradle_plugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.android_x_navigation}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val google_material = "com.google.android.material:material:${Versions.google_material}"
    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines}"
    val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
}

object Androidx {
    val appcompat = "androidx.appcompat:appcompat:${Versions.android_x_appcompat}"
    val core = "androidx.core:core-ktx:${Versions.android_x_core}"
    val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.android_x_constraintlayout}"
    val legacy_support = "androidx.legacy:legacy-support-v4:${Versions.android_x_legacy_support}"

    val navigation_fragment_ktx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.android_x_navigation}"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.android_x_navigation}"

    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.android_x_lifecycle}"
    val lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:${Versions.android_x_lifecycle}"
    val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.android_x_lifecycle}"
    val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.android_x_lifecycle}"

    val security = "androidx.security:security-crypto:${Versions.android_x_security}"
}

object Dagger {

}

object AndroidxTest {
    const val junit = "androidx.test.ext:junit:1.1.1"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.2.0"
}

object Jvm {
    const val junit = "junit:junit:4.12"
}