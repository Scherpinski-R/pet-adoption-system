package br.com.rsbrandao.PetAdoptionSystem.model.donation;

import br.com.rsbrandao.PetAdoptionSystem.model.User;
import br.com.rsbrandao.PetAdoptionSystem.model.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="donations")
@Getter
@Setter
@NoArgsConstructor
public class Donation {

    public Donation(User donor, Pet pet, Double value, DonationType type, String description, Date date) {
        this.setDonor(donor);
        this.setPet(pet);
        this.setValue(value);
        this.setType(type);
        this.setDescription(description);
        this.setDate(date);
    }
    public Donation(User donor, Pet pet, Double value, DonationType type, String description) {
        this(donor, pet, value, type, description, new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private User donor;

    @ManyToOne
    @NotNull
    private Pet pet;

    @Min(0)
    private Double value;

    @Enumerated(EnumType.STRING)
    private DonationType type;

    @NotEmpty
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
