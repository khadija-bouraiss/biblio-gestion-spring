package ma.bibliotheque.gestion.repository;

import ma.bibliotheque.gestion.model.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {
  List<Ouvrage> findByGenre(String genre);
  List<Ouvrage> findByEstDisponible(boolean estDisponible);
  List<Ouvrage> findByEcrivainId(Long ecrivainId);
  List<Ouvrage> findByDesignationContainingIgnoreCase(String designation);
}