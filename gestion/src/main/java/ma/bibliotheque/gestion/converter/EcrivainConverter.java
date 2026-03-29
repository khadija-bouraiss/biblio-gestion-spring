package ma.bibliotheque.gestion.converter;

import ma.bibliotheque.gestion.model.Ecrivain;
import ma.bibliotheque.gestion.service.EcrivainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EcrivainConverter implements Converter<String, Ecrivain> {

  @Autowired
  private EcrivainService ecrivainService;

  @Override
  public Ecrivain convert(String id) {
    if (id == null || id.isEmpty()) return null;
    return ecrivainService.findById(Long.parseLong(id));
  }
}