package steps

import io.github.oshai.kotlinlogging.KotlinLogging
import org.openqa.selenium.WebDriver
import tests.pages.NewProfilePicPage
import tests.utils.FileHelper
import tests.utils.LogParser

internal class NewProfilePicSteps(private val driver: WebDriver) {
    private val page = NewProfilePicPage(driver)
    private val logger = KotlinLogging.logger {}

    fun openAndProcessPhoto(targetUrl: String, photoUrl: String) {
        logger.info { "Opening URL: $targetUrl" }
        page.open(targetUrl)

        logger.info { "Triggering photo processing with: $photoUrl" }
        page.triggerPhotoProcessing(photoUrl)

        logger.info { "Clicking Save and Share" }
        page.clickSaveAndShare()
    }

    fun captureResult(screenshotName: String) {
        val screenshot = page.takeScreenshot()
        FileHelper.saveScreenshot(screenshotName, screenshot)
        logger.info { "Screenshot saved: $screenshotName" }
    }

    fun getResultImageUrl(): String {
        return LogParser.waitForDownloadUrl(driver)
    }
}