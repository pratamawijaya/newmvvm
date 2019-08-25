object Config {
    val minSdk = 21
    val targetSdk = 29
    val buildTools = "29.0.1"
}

object Versions {
    val kotlin = "1.3.41"
    val gradle = "3.5.0"
    val core_ktx = "1.0.2"
    val appcompat = "1.0.2"
    val constraint_layout = "1.1.3"
    val junit = "4.12"
    val test_runner = "1.1.1"
    val espresso_core = "3.2.0"
    val koin = "2.0.1"
}

object Deps {
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val tools_kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val tools_gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    val lib_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val lib_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val lib_constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val lib_junit = "junit:junit:${Versions.junit}"
    val lib_test_runner = "androidx.test:runner:${Versions.test_runner}"
    val lib_espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    val lib_koin_core = "org.koin:koin-core:${Versions.koin}"
    val lib_koin_test = "org.koin:koin-test:${Versions.koin}"
    val lib_koin_scope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val lib_koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}