package tests.utils.okHttp

import io.github.oshai.kotlinlogging.KotlinLogging
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer

internal class HttpLoggingInterceptor : Interceptor {
    private val logger = KotlinLogging.logger {}

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logRequest(request)
        val response = chain.proceed(request)
        return logResponse(response)
    }

    private fun logRequest(request: Request) {
        val bodyString = request.body?.let {
            val buffer = Buffer()
            it.writeTo(buffer)
            buffer.readUtf8()
        }
        logger.info {
            """
            |Request:
            |Method: ${request.method}
            |URL: ${request.url}
            |Headers: ${request.headers}
            ${bodyString?.let { "|Body: $bodyString" }}
            """.trimMargin()
        }
    }

    private fun logResponse(response: Response): Response {
        val contentType = response.header("Content-Type")
        val isText = contentType?.let {
            it.contains("text") || it.contains("json") || it.contains("xml")
        } ?: false
        val responseBodyString = if (isText) {
            response.peekBody(Long.MAX_VALUE).string()
        } else {
            "[Binary Content: $contentType, Size: ${response.body?.contentLength()} bytes]"
        }

        logger.info {
            """
        |Response:
        |Status: ${response.code} ${response.message}
        |Headers: ${response.headers}
        |Body: $responseBodyString
        """.trimMargin()
        }
        return response
    }
}