package tests.utils

import okhttp3.Request
import tests.utils.okHttp.OkHttpClientProvider
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

internal object FileHelper {
    fun saveScreenshot(name: String, bytes: ByteArray) {
        val path = Paths.get("build/screenshots")
        if (!Files.exists(path)) {
            Files.createDirectories(path)
        }
        File(path.toFile(), "$name.png").writeBytes(bytes)
    }

    fun isUrlDownloadable(url: String): Boolean {
        val request = Request.Builder().url(url).build()
        OkHttpClientProvider.okHttpClient.newCall(request).execute().use { response ->
            return (response.body?.contentLength() ?: 0) > 0
        }
    }
}