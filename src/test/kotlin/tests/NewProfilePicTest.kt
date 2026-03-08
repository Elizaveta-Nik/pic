package tests.tests

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import tests.pages.NewProfilePicPage
import tests.utils.Config.targetUrl
import tests.utils.Config.testPhotoUrl
import tests.utils.FileHelper
import tests.utils.LogParser

internal class NewProfilePicTest : BaseTest() {

    @Test
    fun `should process photo and verify result`() {
        NewProfilePicPage(driver)
            .open(targetUrl)
            .triggerPhotoProcessing(testPhotoUrl)
            .clickSaveAndShare()
        val downloadUrl = LogParser.waitForDownloadUrl(driver)
        assertTrue(FileHelper.isUrlDownloadable(downloadUrl),
            "Resource at $downloadUrl is not reachable (HTTP 200 expected)")
    }
}