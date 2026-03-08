package tests.pages

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

internal abstract class BasePage(protected val driver: WebDriver) {
    protected val wait: WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(10))
    protected val jsExecutor: JavascriptExecutor = driver as JavascriptExecutor
    protected val actions: Actions by lazy { Actions(driver) }

    fun waitForPageLoad() {
        wait.until {
            jsExecutor.executeScript("return document.readyState") == "complete"
        }
    }
}