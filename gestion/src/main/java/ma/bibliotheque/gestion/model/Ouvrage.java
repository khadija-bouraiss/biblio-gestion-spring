package ma.bibliotheque.gestion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Ouvrage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "La désignation est obligatoire")
  private String designation;

  @NotBlank(message = "Le code ouvrage est obligatoire")
  private String codeOuvrage;

  @NotBlank(message = "Le genre est obligatoire")
  private String genre;

  @NotNull(message = "L'année d'édition est obligatoire")
  private LocalDate anneeEdition;

  private boolean estDisponible = true;

  @ManyToOne
  @JoinColumn(name = "ecrivain_id")
  private Ecrivain ecrivain;
}