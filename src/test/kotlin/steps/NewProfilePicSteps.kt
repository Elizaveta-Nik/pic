package steps

import org.openqa.selenium.WebDriver
import tests.pages.NewProfilePicPage
import tests.utils.LogParser

internal class NewProfilePicSteps(private val driver: WebDriver) {
    private val page = NewProfilePicPage(driver)

    fun openAndProcessPhoto(targetUrl: String, photoUrl: String) {
        page.open(targetUrl)
            .triggerPhotoProcessing(photoUrl)
            .clickSaveAndShare()
    }

    fun getResultImageUrl(): String {
        return LogParser.waitForDownloadUrl(driver)
    }
}