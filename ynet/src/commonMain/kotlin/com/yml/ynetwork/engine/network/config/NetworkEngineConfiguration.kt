package com.yml.ynetwork.engine.network.config

import com.yml.ynetwork.constants.THREAD_COUNT_NOT_DEFINED
import com.yml.ynetwork.constants.TIMEOUT_NOT_DEFINED
import com.yml.ynetwork.proxy.ProxyConfig
import com.yml.ynetwork.request.FileTransferProgressCallback

/**
 * Data class holding the configuration for [com.accelerator.network.core.engine.network.NetworkEngine].
 *
 * @property timeout default timeout while making network request in milliseconds.
 * @property threadCount number of threads to use while making parallel network requests.
 * @property sslPinningConfig configuration for SSL pinning.
 * @property proxyConfig configuration for setting proxy servers.
 * @property fileTransferProgressCallback callback for file upload progress.
 */
data class NetworkEngineConfiguration(
    val timeout: Long = TIMEOUT_NOT_DEFINED,
    val threadCount: Int = THREAD_COUNT_NOT_DEFINED,
    val sslPinningConfig: SSLPinningConfiguration? = null,
    val proxyConfig: ProxyConfig? = null,
    val fileTransferProgressCallback: FileTransferProgressCallback? = null
)
