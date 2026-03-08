package tests.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

internal object LogParser {
    fun waitForDownloadUrl(driver: WebDriver, timeoutSeconds: Long = 60): String {
        val result = WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
            .withMessage("Could not find the result image URL in browser logs")
            .until {
                driver.manage().logs().get(LogType.BROWSER)
                    .map { it.message }
                    .find { it.contains(Config.EXPECTED_DOMAIN) && it.contains(Config.FILE_EXTENSION) }
                    ?.let { Config.URL_REGEX.find(it)?.value }
            }
        return checkNotNull(result)
    }
}