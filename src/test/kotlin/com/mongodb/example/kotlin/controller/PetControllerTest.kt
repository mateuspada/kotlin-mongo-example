package com.mongodb.example.kotlin.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.example.kotlin.MockMvcMongoBase
import com.mongodb.example.kotlin.model.Pet
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


class PetControllerTest : MockMvcMongoBase(Pet::class) {

    @Test
    fun shouldCreateAnPet() {
        val pet = Pet(name = "teste", species = "especie", breed = "breed")

        mockMvc.perform(MockMvcRequestBuilders.post("/pets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper().writeValueAsString(pet)))
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun shoulFindAllPets() {
        val pet = Pet(name = "Mateus", species = "Especie do Mateus", breed = "Raça do Mateus")

        mockMvc.perform(MockMvcRequestBuilders.post("/pets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper().writeValueAsString(pet)))

        mockMvc.perform(MockMvcRequestBuilders.get("/pets"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", CoreMatchers.notNullValue()))
    }

}