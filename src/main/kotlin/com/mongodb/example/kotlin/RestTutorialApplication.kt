package com.mongodb.example.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestTutorialApplication

fun main(args: Array<String>) {
    runApplication<RestTutorialApplication>(*args)
}
