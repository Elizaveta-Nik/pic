package tests.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import models.Combo
import java.io.File

internal object ComboProvider {
    private val mapper = jacksonObjectMapper()

    fun getCombos(): List<Combo> {
        val inputStream = this::class.java.classLoader.getResourceAsStream("combos.json")
            ?: throw IllegalStateException("combos.json not found in resources")
        return mapper.readValue(inputStream)
    }
}
