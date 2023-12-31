package br.com.rsbrandao.PetAdoptionSystem.controllers;

import br.com.rsbrandao.PetAdoptionSystem.model.User;
import br.com.rsbrandao.PetAdoptionSystem.model.donation.Donation;
import br.com.rsbrandao.PetAdoptionSystem.model.donation.DonationType;
import br.com.rsbrandao.PetAdoptionSystem.model.pet.Pet;
import br.com.rsbrandao.PetAdoptionSystem.repositories.DonationRepository;
import br.com.rsbrandao.PetAdoptionSystem.repositories.PetRepository;
import br.com.rsbrandao.PetAdoptionSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/donation")
public class DonationController {
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetRepository petRepository;

    @PostMapping("/{petID}/{donorID}")
    public Donation newDonation(@PathVariable long petID, @PathVariable long donorID, double price, DonationType donationType, String description) {
        Optional<Pet> pet = petRepository.findById(petID);
        Optional<User> donor = userRepository.findById(donorID);

        if (pet.isEmpty() || donor.isEmpty()) return null;

        Donation donation = new Donation(donor.get(), pet.get(), price, donationType, description);
        return donationRepository.save(donation);
    }

    @GetMapping("/{id}/pet")
    public Iterable<Donation> donationsForPetID(@PathVariable long id) {
        return petRepository.findById(id).map(Pet::getDonations).orElse(null);
    }

    @GetMapping
    public Iterable<Donation> getDonations() {
        return donationRepository.findAll();
    }
}
