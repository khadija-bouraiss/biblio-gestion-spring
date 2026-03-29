package ma.bibliotheque.gestion.service;

import ma.bibliotheque.gestion.model.Ecrivain;
import ma.bibliotheque.gestion.repository.EcrivainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EcrivainService {

  @Autowired
  private EcrivainRepository ecrivainRepository;

  public List<Ecrivain> findAll() {
    return ecrivainRepository.findAll();
  }

  public Ecrivain findById(Long id) {
    return ecrivainRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ecrivain introuvable : " + id));
  }

  public void save(Ecrivain ecrivain) {
    ecrivainRepository.save(ecrivain);
  }

  public void delete(Long id) {
    ecrivainRepository.deleteById(id);
  }

  public List<Ecrivain> findByNom(String nom) {
    return ecrivainRepository.findByNomContainingIgnoreCase(nom);
  }

  public List<Ecrivain> findByPays(String pays) {
    return ecrivainRepository.findByPays(pays);
  }
}