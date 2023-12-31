package br.com.rsbrandao.PetAdoptionSystem.repositories;

import br.com.rsbrandao.PetAdoptionSystem.model.pet.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
