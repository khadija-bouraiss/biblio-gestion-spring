package ma.bibliotheque.gestion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Pret {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "La date de prêt est obligatoire")
  private LocalDate datePret;

  @NotNull(message = "La date d'échéance est obligatoire")
  private LocalDate dateEcheance;

  private LocalDate dateRendu;

  private String etat; // EN_COURS, RENDU, EN_RETARD

  @ManyToOne
  @JoinColumn(name = "ouvrage_id")
  private Ouvrage ouvrage;
}