package com.yml.ynetwork.engine.cache

import com.yml.ynetwork.Resource
import com.yml.ynetwork.request.DataRequest
import com.yml.ynetwork.response.DataResponse
import kotlinx.coroutines.flow.Flow

/**
 * Class/Interface responsible for making the local cache data requests.
 */
interface CacheEngine {

    /**
     * Submit a data request to the [CacheEngine] to get a data response.
     *
     * @param request a [DataRequest] containing the request data.
     *
     * @return [Flow] containing the response data.
     */
    fun submit(request: DataRequest<String>): Flow<Resource<DataResponse<String>>>
}