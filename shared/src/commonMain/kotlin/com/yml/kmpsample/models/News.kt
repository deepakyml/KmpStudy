package com.yml.kmpsample.models

import kotlinx.serialization.Serializable

@Serializable
data class NewsArticle(
    val author: String?=null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
    val title: String?=null,
    val url: String?=null,
    val urlToImage: String?=null
)