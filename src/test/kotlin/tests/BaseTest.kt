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
        }
        driver = ChromeDriver(options)
        driver.manage().window().maximize()
    }

    @AfterEach
    fun tearDown() {
        if (this::driver.isInitialized) driver.quit()
    }
}