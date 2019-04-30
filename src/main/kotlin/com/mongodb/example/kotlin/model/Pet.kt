package com.mongodb.example.kotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "pets")
data class Pet(@Id val id: String = UUID.randomUUID().toString(),
               val name: String,
               val species: String,
               val breed: String)