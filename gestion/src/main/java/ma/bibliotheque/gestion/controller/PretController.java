package ma.bibliotheque.gestion.controller;

import ma.bibliotheque.gestion.model.Pret;
import ma.bibliotheque.gestion.service.OuvrageService;
import ma.bibliotheque.gestion.service.PretService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prets")
public class PretController {

  @Autowired
  private PretService pretService;

  @Autowired
  private OuvrageService ouvrageService;

  @GetMapping
  public String list(Model model,
                     @RequestParam(required = false) String etat) {
    if (etat != null && !etat.isEmpty()) {
      model.addAttribute("prets", pretService.findByEtat(etat));
    } else {
      model.addAttribute("prets", pretService.findAll());
    }
    return "prets/list";
  }

  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("pret", new Pret());
    model.addAttribute("ouvrages", ouvrageService.findByDisponibilite(true));
    return "prets/form";
  }

  @PostMapping("/save")
  public String save(@Valid Pret pret, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("ouvrages", ouvrageService.findByDisponibilite(true));
      return "prets/form";
    }
    pretService.save(pret);
    return "redirect:/prets";
  }

  @GetMapping("/retour/{id}")
  public String retournerOuvrage(@PathVariable Long id) {
    pretService.retournerOuvrage(id);
    return "redirect:/prets";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    pretService.delete(id);
    return "redirect:/prets";
  }

  @GetMapping("/stats")
  public String stats(Model model) {
    model.addAttribute("pretParMois", pretService.getPretParMois());
    model.addAttribute("ecrivainsPopulaires", pretService.getEcrivainsLesPlusEmpruntes());
    model.addAttribute("tauxRetard", pretService.getTauxRetard());
    return "prets/stats";
  }
}