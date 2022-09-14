package com.yml.kmpsample.response

import kotlinx.serialization.Serializable

@Serializable
data class NewsCatcherApiResponse(
    val articles: List<NewsCatcherArticle>,
    val page: Int,
    val page_size: Int,
    val status: String,
    val total_hits: Int,
    val total_pages: Int,
)

@Serializable
data class NewsCatcherArticle(
    val author: String,
    val authors: String,
    val excerpt: String,
    val link: String,
    val media: String,
    val published_date: String,
    val summary: String,
    val title: String,
    val topic: String)
