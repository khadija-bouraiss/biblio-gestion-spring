package ma.bibliotheque.gestion.repository;

import ma.bibliotheque.gestion.model.Ecrivain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EcrivainRepository extends JpaRepository<Ecrivain, Long> {
  List<Ecrivain> findByNomContainingIgnoreCase(String nom);
  List<Ecrivain> findByPays(String pays);
}