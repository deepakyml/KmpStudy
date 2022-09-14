package com.yml.kmpsample

import com.yml.kmpsample.models.NewsArticle
import com.yml.kmpsample.network.NewsApi
import com.yml.kmpsample.response.NewsCatcherApiResponse

class NewsUseCase() {
    private val newsApi: NewsApi = NewsApi()
    private var cachedResponse:List<NewsArticle> = arrayListOf()
    suspend fun fetchTopNews(): List<NewsArticle>{
        if (cachedResponse.isEmpty()){
           cachedResponse= newsApi.getNewsFromNewsCatcher().toAppModel()
        }
    return  cachedResponse
    }
}

private fun NewsCatcherApiResponse.toAppModel(): List<NewsArticle> {
    return if(articles.isEmpty()){
        ArrayList()
    }else {
        val curatedArticles = arrayListOf<NewsArticle>()
        articles.forEach {
            curatedArticles.add(NewsArticle(it.author,it.excerpt,it.summary,it.published_date,it.title,it.link,it.media))
        }
        curatedArticles
    }
}

