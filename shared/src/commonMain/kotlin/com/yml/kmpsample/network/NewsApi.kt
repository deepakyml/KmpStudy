package com.yml.kmpsample.network

import com.yml.kmpsample.httpClient
import com.yml.kmpsample.response.NewsApiOrgResponse
import com.yml.kmpsample.response.NewsCatcherApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NewsApi {
    private val NEWS_API_ORG_API_KEY = "e4697628b29744cdb7051251b345b052"
    private val NEWS_API_ORG_URL="https://newsapi.org/v2/top-headlines?country=in&apiKey=$NEWS_API_ORG_API_KEY"

    private val NEWS_CATCHER_API_KEY = "2d94vxaHZy_kr6k8OzzhfgPCwxYa9IFzyaH7wWCt3AY"
    private val NEWS_CATCHER_URL="https://api.newscatcherapi.com/v2/latest_headlines?countries=IN&topic=tech&lang=En"


    private val httpClient: HttpClient = httpClient{
        install(Logging)
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

    }

    internal suspend fun getNewsFromNewsApiOrg(): NewsApiOrgResponse {
        return httpClient.get(NEWS_API_ORG_URL).body()
    }

    internal suspend fun getNewsFromNewsCatcher(): NewsCatcherApiResponse {
        return httpClient.get(NEWS_CATCHER_URL){
            headers{
                append("x_api_key",NEWS_CATCHER_API_KEY)
            }
        }.body()
    }




}