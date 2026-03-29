package ma.bibliotheque.gestion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Ecrivain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Le nom est obligatoire")
  private String nom;

  @NotBlank(message = "Le pays est obligatoire")
  private String pays;

  @OneToMany(mappedBy = "ecrivain", cascade = CascadeType.ALL)
  private List<Ouvrage> ouvrages;
}