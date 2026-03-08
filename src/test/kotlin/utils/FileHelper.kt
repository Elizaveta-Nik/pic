package tests.utils

import okhttp3.Request
import tests.utils.okHttp.OkHttpClientProvider

internal object FileHelper {
    fun isUrlDownloadable(url: String): Boolean {
        val request = Request.Builder().url(url).build()
        OkHttpClientProvider.okHttpClient.newCall(request).execute().use { response ->
            return (response.body?.contentLength() ?: 0) > 0
        }
    }
}