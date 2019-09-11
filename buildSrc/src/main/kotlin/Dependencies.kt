object Config {
    val minSdk = 21
    val targetSdk = 29
    val buildTools = "29.0.1"
}

object Modules {
    val app = ":app"
    val common_core = ":common-android:core"
    val common_android_navigation = ":common-android:navigation"
    val common_android_network = ":common-android:network"
    val common_android_uicomponents = ":common-android:uicomponents"

    val features_onboarding = ":features:onboarding"
    val features_homepage = ":features:homepage"
    val features_newsapi_list = ":features:newsapi_list"
    val features_open_dota = ":features:opendota"
}


object Versions {
    val kotlin = "1.3.50"
    val gradle = "3.5.0"
    val core_ktx = "1.0.2"
    val appcompat = "1.0.2"
    val constraint_layout = "1.1.3"
    val junit = "4.12"
    val test_runner = "1.1.1"
    val espresso_core = "3.2.0"
    val koin = "2.0.1"
    val androidx_navigation = "2.1.0-rc01"
    val android_material = "1.1.0-alpha09"
    val timberkt = "1.5.1"
    val retrofit = "2.6.1"
    val logging_interceptor = "4.1.0"
    val retrofit_coroutine_adapter = "0.9.2"
    val coroutines = "1.1.1"
    val truth = "0.42"
    val gradle_version_plugin = "0.23.0"
    val viewmodel_ktx = "2.2.0-alpha01"
    val livedata = "2.2.0-alpha01"
    val epoxy = "3.7.0"
    val sdpssp = "1.0.6"
    val butterknife_plugin = "10.1.0"
    val room = "2.2.0-beta01"
    val groupie = "2.5.1"
    val picasso = "2.71828"
}

object Deps {
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val tools_kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val tools_gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val tools_gradle_lib_version = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradle_version_plugin}"
    val tools_butterknife_plugin = "com.jakewharton:butterknife-gradle-plugin:${Versions.butterknife_plugin}"

    val lib_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val lib_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    val lib_livedata_extension = "androidx.lifecycle:lifecycle-extensions:${Versions.livedata}"
    val lib_livedata = "androidx.lifecycle:lifecycle-livedata:${Versions.livedata}"
    // viewmodelscope
    val lib_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel_ktx}"
    // lifecycleruntime
    val lib_viewmodel_lifecycleruntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewmodel_ktx}"
    // livedata
    val lib_viewmodel_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewmodel_ktx}"

    val lib_timberkt = "com.github.ajalt:timberkt:${Versions.timberkt}"
    val lib_material = "com.google.android.material:material:${Versions.android_material}"
    val lib_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val lib_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val lib_constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

    val lib_koin_core = "org.koin:koin-core:${Versions.koin}"
    val lib_koin_scope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val lib_koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    val lib_navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    val lib_navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"

    val lib_retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val lib_retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val lib_okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    val lib_retrofit_coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_coroutine_adapter}"

    val lib_groupie = "com.xwray:groupie:${Versions.groupie}"
    val lib_groupie_extension = "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"
    val lib_epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    val lib_processor_epoxy = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"

    val lib_room = "androidx.room:room-runtime:${Versions.room}"
    val lib_processor_room = "androidx.room:room-compiler:${Versions.room}"
    val lib_room_coroutines = "androidx.room:room-ktx:${Versions.room}"
    val lib_test_room = "androidx.room:room-testing:${Versions.room}"

    val lib_ssp = "com.intuit.ssp:ssp-android:${Versions.sdpssp}"
    val lib_sdp = "com.intuit.sdp:sdp-android:${Versions.sdpssp}"

    val lib_picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    val lib_test_google_truth = "com.google.truth:truth:${Versions.truth}"
    val lib_test_koin = "org.koin:koin-test:${Versions.koin}"
    val lib_test_runner = "androidx.test:runner:${Versions.test_runner}"
    val lib_test_espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    val lib_test_junit = "junit:junit:${Versions.junit}"
}