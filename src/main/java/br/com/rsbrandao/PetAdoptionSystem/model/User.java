package br.com.rsbrandao.PetAdoptionSystem.model;

import br.com.rsbrandao.PetAdoptionSystem.model.donation.Donation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotEmpty
   private String name;

   @Temporal(TemporalType.TIMESTAMP)
   private Date creationDate;

   @OneToMany(mappedBy = "donor")
   private List<Donation> donations = new ArrayList<>();

}
