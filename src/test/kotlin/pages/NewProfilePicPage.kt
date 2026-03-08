package tests.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions

internal class NewProfilePicPage(driver: WebDriver) : BasePage(driver) {
    private val saveAndShareButton = By.cssSelector("button.btn-download")

    fun open(url: String) = apply {
        driver.get(url)
        waitForPageLoad()
    }

    fun triggerPhotoProcessing(imageUrl: String) = apply {
        jsExecutor.executeScript("pw_onPhotosSelected({ photos: [{ image_url: '$imageUrl' }] });")
    }

    fun clickSaveAndShare() = apply {
        wait.until(ExpectedConditions.elementToBeClickable(saveAndShareButton)).click()
    }
}