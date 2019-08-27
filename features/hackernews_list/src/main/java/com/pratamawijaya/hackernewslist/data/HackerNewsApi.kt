package com.pratamawijaya.hackernewslist.data

import retrofit2.http.GET

interface HackerNewsApi {

    @GET("topstories.json")
    fun topStories()
}