package br.com.rsbrandao.PetAdoptionSystem.controllers;

import br.com.rsbrandao.PetAdoptionSystem.model.pet.Pet;
import br.com.rsbrandao.PetAdoptionSystem.repositories.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetRepository petRepository;
    @Autowired
    public PetController(final PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @PostMapping
    public Pet newPet(@Valid Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping
    public Iterable<Pet> getPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pet> getPetByID(@PathVariable long id) {
       return petRepository.findById(id);
    }

    @PutMapping
    public Pet editPet(@Valid Pet petEdit) {
        return petRepository.save(petEdit);
    }

    @DeleteMapping("/{id}")
    public void removeByID(@PathVariable long id) {
        petRepository.deleteById(id);
    }
}
