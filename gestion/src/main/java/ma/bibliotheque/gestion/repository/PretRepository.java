package ma.bibliotheque.gestion.repository;

import ma.bibliotheque.gestion.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PretRepository extends JpaRepository<Pret, Long> {
  List<Pret> findByEtat(String etat);
  List<Pret> findByDatePretBetween(LocalDate debut, LocalDate fin);
  List<Pret> findByOuvrageId(Long ouvrageId);

  // Statistiques : nombre d'emprunts par mois
  @Query("SELECT MONTH(p.datePret), COUNT(p) FROM Pret p GROUP BY MONTH(p.datePret)")
  List<Object[]> countPretParMois();

  // Statistiques : auteurs les plus empruntés
  @Query("SELECT p.ouvrage.ecrivain.nom, COUNT(p) FROM Pret p GROUP BY p.ouvrage.ecrivain.nom ORDER BY COUNT(p) DESC")
  List<Object[]> ecrivainsLesPlusEmpruntes();

  // Statistiques : taux de retard
  @Query("SELECT COUNT(p) FROM Pret p WHERE p.etat = 'EN_RETARD'")
  Long countPretEnRetard();
}