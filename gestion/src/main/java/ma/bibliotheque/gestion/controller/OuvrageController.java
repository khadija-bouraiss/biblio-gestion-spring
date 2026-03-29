package ma.bibliotheque.gestion.controller;

import ma.bibliotheque.gestion.model.Ouvrage;
import ma.bibliotheque.gestion.service.EcrivainService;
import ma.bibliotheque.gestion.service.OuvrageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ouvrages")
public class OuvrageController {

  @Autowired
  private OuvrageService ouvrageService;

  @Autowired
  private EcrivainService ecrivainService;

  @GetMapping
  public String list(Model model,
                     @RequestParam(required = false) String genre,
                     @RequestParam(required = false) String designation,
                     @RequestParam(required = false) Long ecrivainId,
                     @RequestParam(required = false) Boolean estDisponible) {
    if (genre != null && !genre.isEmpty()) {
      model.addAttribute("ouvrages", ouvrageService.findByGenre(genre));
    } else if (designation != null && !designation.isEmpty()) {
      model.addAttribute("ouvrages", ouvrageService.findByDesignation(designation));
    } else if (ecrivainId != null) {
      model.addAttribute("ouvrages", ouvrageService.findByEcrivain(ecrivainId));
    } else if (estDisponible != null) {
      model.addAttribute("ouvrages", ouvrageService.findByDisponibilite(estDisponible));
    } else {
      model.addAttribute("ouvrages", ouvrageService.findAll());
    }
    model.addAttribute("ecrivains", ecrivainService.findAll());
    return "ouvrages/list";
  }

  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("ouvrage", new Ouvrage());
    model.addAttribute("ecrivains", ecrivainService.findAll());
    return "ouvrages/form";
  }

  @PostMapping("/save")
  public String save(@Valid Ouvrage ouvrage, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("ecrivains", ecrivainService.findAll());
      return "ouvrages/form";
    }
    ouvrageService.save(ouvrage);
    return "redirect:/ouvrages";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    model.addAttribute("ouvrage", ouvrageService.findById(id));
    model.addAttribute("ecrivains", ecrivainService.findAll());
    return "ouvrages/form";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    ouvrageService.delete(id);
    return "redirect:/ouvrages";
  }

  @GetMapping("/toggle/{id}")
  public String toggleDisponibilite(@PathVariable Long id) {
    ouvrageService.toggleDisponibilite(id);
    return "redirect:/ouvrages";
  }
}