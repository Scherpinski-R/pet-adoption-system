package br.com.rsbrandao.PetAdoptionSystem.model.pet;

import br.com.rsbrandao.PetAdoptionSystem.model.donation.Donation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    public Pet(String name, int months, PetKind kind, String breed) {
        this.setName(name);
        this.setMonths(months);
        this.setKind(kind);
        this.setBreed(breed);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PetKind kind;

    @NotEmpty
    private String breed;

    @NotEmpty
    private String name;

    @Min(0)
    private int months;

    @OneToMany(mappedBy = "pet")
    private List<Donation> donations;

}
