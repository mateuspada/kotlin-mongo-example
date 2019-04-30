package com.mongodb.example.kotlin.controller

import com.mongodb.example.kotlin.model.Pet
import com.mongodb.example.kotlin.repository.PetRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/pets")
class PetController(val repository: PetRepository) {
    @GetMapping
    fun getAllPets(): List<Pet> = repository.findAll()

    @GetMapping("/{id}")
    fun getPetById(@PathVariable("id") id: String) = repository.findById(id)

    @PostMapping
    fun createPet(@Valid @RequestBody pet: Pet): Pet {
        repository.save(pet)
        return pet
    }

    @PutMapping("/{id}")
    fun modifyPetById(@PathVariable("id") id: String,
                      @Valid @RequestBody pet: Pet): Pet {
        if (repository.findById(id).isPresent) {
            val newPet = pet.copy(id = id)
            return repository.save(newPet)
        } else {
            throw Exception("Not Found")
        }
    }

    @DeleteMapping("/{id}")
    fun deletePet(@PathVariable("id") id: String) {
        val pet = repository.findById(id)
                .orElseThrow { Exception("Not Found") }

        repository.delete(pet)
    }
}