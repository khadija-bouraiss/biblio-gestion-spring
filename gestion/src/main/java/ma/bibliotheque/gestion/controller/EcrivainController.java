package ma.bibliotheque.gestion.controller;

import ma.bibliotheque.gestion.model.Ecrivain;
import ma.bibliotheque.gestion.service.EcrivainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ecrivains")
public class EcrivainController {

  @Autowired
  private EcrivainService ecrivainService;

  @GetMapping
  public String list(Model model,
                     @RequestParam(required = false) String nom,
                     @RequestParam(required = false) String pays) {
    if (nom != null && !nom.isEmpty()) {
      model.addAttribute("ecrivains", ecrivainService.findByNom(nom));
    } else if (pays != null && !pays.isEmpty()) {
      model.addAttribute("ecrivains", ecrivainService.findByPays(pays));
    } else {
      model.addAttribute("ecrivains", ecrivainService.findAll());
    }
    return "ecrivains/list";
  }

  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("ecrivain", new Ecrivain());
    return "ecrivains/form";
  }

  @PostMapping("/save")
  public String save(@Valid Ecrivain ecrivain, BindingResult result) {
    if (result.hasErrors()) {
      return "ecrivains/form";
    }
    ecrivainService.save(ecrivain);
    return "redirect:/ecrivains";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    model.addAttribute("ecrivain", ecrivainService.findById(id));
    return "ecrivains/form";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    ecrivainService.delete(id);
    return "redirect:/ecrivains";
  }
}