package tests.utils.okHttp

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

internal object OkHttpClientProvider {
    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(HttpStatusCodeInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }
}