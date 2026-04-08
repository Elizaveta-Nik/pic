package tests.utils

internal object Config {
    const val EXPECTED_DOMAIN = "temp-images.ws.pho.to"
    const val FILE_EXTENSION = ".jpeg"
    val URL_REGEX = """(https?://$EXPECTED_DOMAIN/[^\s"']+)""".toRegex()
    const val BASE_URL = "https://newprofilepic.com/"

    val TEST_PHOTOS = mapOf(
        "woman" to "https://photolab-tester2.photo-cdn.net/storage/cd/e7/c4/181.jpeg",
        "man" to "https://photolab-tester.photo-cdn.net/storage/b7/41/36/532.jpeg",
        "child" to "https://photolab-tester.photo-cdn.net/storage/1c/b4/43/363.jpeg"
    )

    fun getTargetUrl(comboId: String) = "$BASE_URL?aid=$comboId"
}
