package com.yml.ynetwork.config

import com.yml.ynetwork.Headers
import com.yml.ynetwork.engine.cache.CacheEngine
import com.yml.ynetwork.engine.network.NetworkEngine
import com.yml.ynetwork.engine.network.config.SSLPinningConfiguration
import com.yml.ynetwork.interceptors.Interceptor
import com.yml.ynetwork.parser.DataParserFactory
import com.yml.ynetwork.proxy.ProxyConfig
import com.yml.ynetwork.request.CachePolicy
import com.yml.ynetwork.request.FileTransferProgressCallback

/**
 * Class responsible for holding the configuration for network manager.
 *
 * @constructor Create the Configuration for NetworkManager
 * @property networkEngine for making network data requests
 * @property dataParserFactory for parsing the data.
 * @property basePath root path which will be used with relative URL for creating a full URL.
 * @property cacheEngine for making data requests to local cache.
 * @property platformConfig a Map of [PlatformConfiguration] w.r.t. the platform name.
 * @property sslPinningConfiguration configuration for SSL pinning.
 * @property shouldFollowRedirect specify whether the HTTP redirection should be followed or not.
 * @property headers which needs to be sent with each request.
 * @property timeout default timeout while making network request in milliseconds.
 * @property threadCount number of threads to use while making parallel network requests.
 * @property defaultCachePolicy default [CachePolicy] to use when cachePolicy not specified in [com.accelerator.network.core.request.DataRequest].
 * @property interceptors list of interceptor implemented.
 * @property fileTransferProgressCallback callback for file upload progress.
 */
internal data class NetworkManagerConfiguration(
    val networkEngine: NetworkEngine,
    override val dataParserFactory: DataParserFactory,
    val basePath: String?,
    val cacheEngine: CacheEngine?,
    val platformConfig: Map<String, PlatformConfiguration>?,
    val sslPinningConfiguration: SSLPinningConfiguration?,
    val shouldFollowRedirect: Boolean,
    val headers: Headers?,
    val proxyConfig: ProxyConfig?,
    override val timeout: Long,
    override val threadCount: Int,
    override val defaultCachePolicy: CachePolicy,
    override val interceptors: List<Interceptor>?,
    override val fileTransferProgressCallback: FileTransferProgressCallback?
) : PlatformConfiguration(
    timeout,
    threadCount,
    dataParserFactory,
    defaultCachePolicy,
    interceptors,
    fileTransferProgressCallback
)
