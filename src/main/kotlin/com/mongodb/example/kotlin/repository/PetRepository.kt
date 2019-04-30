package com.mongodb.example.kotlin.repository

import com.mongodb.example.kotlin.model.Pet
import org.springframework.data.mongodb.repository.MongoRepository

interface PetRepository : MongoRepository<Pet, String>