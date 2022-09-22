package com.yml.ynetwork.config

import com.yml.ynetwork.constants.THREAD_COUNT_NOT_DEFINED
import com.yml.ynetwork.constants.TIMEOUT_NOT_DEFINED
import com.yml.ynetwork.interceptors.Interceptor
import com.yml.ynetwork.parser.DataParserFactory
import com.yml.ynetwork.request.CachePolicy
import com.yml.ynetwork.request.FileTransferProgressCallback

/**
 * Class to hold the configuration data that can be platform specific.
 *
 * @property timeout default timeout while making network request in milliseconds.
 * @property threadCount number of threads to use while making parallel network requests.
 * @property dataParserFactory for parsing the data.
 * @property defaultCachePolicy default [CachePolicy] to use when cachePolicy not specified in [com.accelerator.network.core.request.DataRequest].
 * @property fileTransferProgressCallback callback for file upload progress.
 * @constructor Create the configuration specific to a platform.
 */
open class PlatformConfiguration(
    open val timeout: Long = TIMEOUT_NOT_DEFINED,
    open val threadCount: Int = THREAD_COUNT_NOT_DEFINED,
    open val dataParserFactory: DataParserFactory? = null,
    open val defaultCachePolicy: CachePolicy = CachePolicy.CacheFailsThenNetwork,
    open val interceptors: List<Interceptor>? = null,
    open val fileTransferProgressCallback: FileTransferProgressCallback? = null
)
