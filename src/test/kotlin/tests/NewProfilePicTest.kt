package tests.tests

import models.Combo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import steps.NewProfilePicSteps
import tests.utils.ComboProvider
import tests.utils.Config
import tests.utils.FileHelper

internal class NewProfilePicTest : BaseTest() {
    private val steps by lazy { NewProfilePicSteps(driver) }

    @ParameterizedTest(name = "Test combo: {0}")
    @MethodSource("comboProvider")
    fun `should process photo for combo and verify result`(combo: Combo) {
        val targetUrl = Config.getTargetUrl(combo.id)

        // Select an appropriate photo based on categories, default to woman if none match
        val category = combo.categories.firstOrNull { Config.TEST_PHOTOS.containsKey(it) } ?: "woman"
        val photoUrl = Config.TEST_PHOTOS[category]!!

        steps.openAndProcessPhoto(targetUrl, photoUrl)

        val downloadUrl = steps.getResultImageUrl()
        assertTrue(
            FileHelper.isUrlDownloadable(downloadUrl),
            "Resource at $downloadUrl for combo ${combo.name} (${combo.id}) is not reachable"
        )

        steps.captureResult("result_${combo.id}_${combo.name.replace(" ", "_")}")
    }

    companion object {
        @JvmStatic
        fun comboProvider(): List<Combo> = ComboProvider.getCombos()
    }
}
