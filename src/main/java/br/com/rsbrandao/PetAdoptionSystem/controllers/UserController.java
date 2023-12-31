package br.com.rsbrandao.PetAdoptionSystem.controllers;

import br.com.rsbrandao.PetAdoptionSystem.model.User;
import br.com.rsbrandao.PetAdoptionSystem.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserByID(@PathVariable long id) {
       return userRepository.findById(id);
    }
    @PostMapping
    public User newUser(@Valid User user) {
        user.setCreationDate(new Date());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
