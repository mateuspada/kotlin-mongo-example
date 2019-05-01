package com.mongodb.example.kotlin

import org.junit.Assert
import org.junit.Test

class RestTutorialApplicationKtTest : MockMvcBase() {
    @Test
    fun testMain() {
        main(arrayOf<String>())

        Assert.assertTrue(true)
    }
}