package ma.bibliotheque.gestion.service;

import ma.bibliotheque.gestion.model.Ouvrage;
import ma.bibliotheque.gestion.repository.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OuvrageService {

  @Autowired
  private OuvrageRepository ouvrageRepository;

  public List<Ouvrage> findAll() {
    return ouvrageRepository.findAll();
  }

  public Ouvrage findById(Long id) {
    return ouvrageRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ouvrage introuvable : " + id));
  }

  public void save(Ouvrage ouvrage) {
    ouvrageRepository.save(ouvrage);
  }

  public void delete(Long id) {
    ouvrageRepository.deleteById(id);
  }

  public List<Ouvrage> findByGenre(String genre) {
    return ouvrageRepository.findByGenre(genre);
  }

  public List<Ouvrage> findByDisponibilite(boolean estDisponible) {
    return ouvrageRepository.findByEstDisponible(estDisponible);
  }

  public List<Ouvrage> findByEcrivain(Long ecrivainId) {
    return ouvrageRepository.findByEcrivainId(ecrivainId);
  }

  public List<Ouvrage> findByDesignation(String designation) {
    return ouvrageRepository.findByDesignationContainingIgnoreCase(designation);
  }

  public void toggleDisponibilite(Long id) {
    Ouvrage ouvrage = findById(id);
    ouvrage.setEstDisponible(!ouvrage.isEstDisponible());
    ouvrageRepository.save(ouvrage);
  }
}