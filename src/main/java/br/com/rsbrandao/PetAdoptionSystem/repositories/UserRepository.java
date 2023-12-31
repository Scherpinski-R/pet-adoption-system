package br.com.rsbrandao.PetAdoptionSystem.repositories;

import br.com.rsbrandao.PetAdoptionSystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
