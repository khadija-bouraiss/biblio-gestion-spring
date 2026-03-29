package ma.bibliotheque.gestion.service;

import ma.bibliotheque.gestion.model.Ouvrage;
import ma.bibliotheque.gestion.model.Pret;
import ma.bibliotheque.gestion.repository.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PretService {

  @Autowired
  private PretRepository pretRepository;

  @Autowired
  private OuvrageService ouvrageService;

  public List<Pret> findAll() {
    return pretRepository.findAll();
  }

  public Pret findById(Long id) {
    return pretRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Prêt introuvable : " + id));
  }

  public void save(Pret pret) {
    // Marquer l'ouvrage comme indisponible
    Ouvrage ouvrage = pret.getOuvrage();
    ouvrage.setEstDisponible(false);
    ouvrageService.save(ouvrage);
    pret.setEtat("EN_COURS");
    pretRepository.save(pret);
  }

  public void retournerOuvrage(Long id) {
    Pret pret = findById(id);
    pret.setDateRendu(LocalDate.now());

    // Vérifier si retard
    if (LocalDate.now().isAfter(pret.getDateEcheance())) {
      pret.setEtat("EN_RETARD");
    } else {
      pret.setEtat("RENDU");
    }

    // Marquer l'ouvrage comme disponible
    Ouvrage ouvrage = pret.getOuvrage();
    ouvrage.setEstDisponible(true);
    ouvrageService.save(ouvrage);

    pretRepository.save(pret);
  }

  public void delete(Long id) {
    pretRepository.deleteById(id);
  }

  public List<Pret> findByEtat(String etat) {
    return pretRepository.findByEtat(etat);
  }

  public List<Pret> findByPeriode(LocalDate debut, LocalDate fin) {
    return pretRepository.findByDatePretBetween(debut, fin);
  }

  // Statistiques
  public List<Object[]> getPretParMois() {
    return pretRepository.countPretParMois();
  }

  public List<Object[]> getEcrivainsLesPlusEmpruntes() {
    return pretRepository.ecrivainsLesPlusEmpruntes();
  }

  public double getTauxRetard() {
    long totalPrets = pretRepository.count();
    if (totalPrets == 0) return 0;
    long pretsEnRetard = pretRepository.countPretEnRetard();
    return (double) pretsEnRetard / totalPrets * 100;
  }
}