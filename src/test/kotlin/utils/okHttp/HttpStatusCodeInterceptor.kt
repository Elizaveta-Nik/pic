package tests.utils.okHttp

import okhttp3.Interceptor
import okhttp3.Response

internal class HttpStatusCodeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        check(response.isSuccessful) {
            "HTTP Error: ${response.code} ${response.message} for URL: ${chain.request().url}"
        }
        return response
    }
}