package com.mongodb.example.kotlin

import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.dropCollection
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.reflect.KClass

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [RestTutorialApplication::class])
@AutoConfigureMockMvc
abstract class MockMvcMongoBase(val collectionClass: KClass<*>) {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @Autowired
    lateinit var context: WebApplicationContext
    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mongoTemplate.dropCollection(collectionClass)

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build()
    }
}