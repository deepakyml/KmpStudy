package com.yml.kmpsample.response

import kotlinx.serialization.Serializable

@Serializable
data class NewsApiOrgResponse(
    val articles: List<NewsApiOrgArticle>?=null,
    val status: String?=null,
    val totalResults: Int?=null
)

@Serializable
data class NewsApiOrgArticle(
    val author: String?=null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
    val source: NewsApiOrgSource?=null,
    val title: String?=null,
    val url: String?=null,
    val urlToImage: String?=null
)

@Serializable
data class NewsApiOrgSource(
    val id: String?=null,
    val name: String?=null
)