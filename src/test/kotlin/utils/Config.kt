package tests.utils

internal object Config {
    const val EXPECTED_DOMAIN = "temp-images.ws.pho.to"
    const val FILE_EXTENSION = ".jpeg"
    val URL_REGEX = """(https?://$EXPECTED_DOMAIN/[^\s"']+)""".toRegex()
    val targetUrl = "https://newprofilepic.com/?aid=123"
    val testPhotoUrl = "https://photolab-tester2.photo-cdn.net/storage/cd/e7/c4/181.jpeg"
}