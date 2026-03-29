package ma.bibliotheque.gestion.converter;

import ma.bibliotheque.gestion.model.Ouvrage;
import ma.bibliotheque.gestion.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OuvrageConverter implements Converter<String, Ouvrage> {

  @Autowired
  private OuvrageService ouvrageService;

  @Override
  public Ouvrage convert(String id) {
    if (id == null || id.isEmpty()) return null;
    return ouvrageService.findById(Long.parseLong(id));
  }
}
