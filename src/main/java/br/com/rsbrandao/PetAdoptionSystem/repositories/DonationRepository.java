package br.com.rsbrandao.PetAdoptionSystem.repositories;

import br.com.rsbrandao.PetAdoptionSystem.model.donation.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepository extends CrudRepository<Donation, Long> {
}
