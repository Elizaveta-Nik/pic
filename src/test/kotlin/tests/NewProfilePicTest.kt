package tests.tests

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import steps.NewProfilePicSteps
import tests.utils.Config
import tests.utils.FileHelper

internal class NewProfilePicTest : BaseTest() {
    private val steps by lazy { NewProfilePicSteps(driver) }

    @Test
    fun `should process photo and verify result`() {
        steps.openAndProcessPhoto(Config.TARGET_URL, Config.TEST_PHOTO_URL)
        val downloadUrl = steps.getResultImageUrl()
        assertTrue(
            FileHelper.isUrlDownloadable(downloadUrl),
            "Resource at $downloadUrl is not reachable (HTTP 200 expected)"
        )
    }
}