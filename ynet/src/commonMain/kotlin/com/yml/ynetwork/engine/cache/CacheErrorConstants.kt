package com.yml.ynetwork.engine.cache

import com.yml.ynetwork.request.Method

const val CACHE_ERROR_NOT_IMPLEMENTED = "Cache method not implemented"
const val CACHE_ERROR_NOT_FOUND = "Cache data not found"
val cacheErrorMethodNotAllowed =
    { method: Method -> "Demo Cache engine doesn't support $method Method." }
