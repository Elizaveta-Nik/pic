package tests.tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

internal abstract class BaseTest {
    protected lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        val options = ChromeOptions().apply {
            setCapability("goog:loggingPrefs", mapOf("browser" to "ALL"))
            addArguments("--headless")
            addArguments("--no-sandbox")
            addArguments("--disable-dev-shm-usage")

            val mobileEmulation = mapOf("deviceName" to "iPhone 12 Pro")
            setExperimentalOption("mobileEmulation", mobileEmulation)
        }
        driver = ChromeDriver(options)
    }

    @AfterEach
    fun tearDown() {
        if (this::driver.isInitialized) driver.quit()
    }
}