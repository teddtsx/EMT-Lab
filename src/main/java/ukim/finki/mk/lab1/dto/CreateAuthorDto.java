package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Country;

public record CreateAuthorDto(String name, String surname, Long country) {
   public Author toAuthor(Country country) {
      return new Author(name, surname, country);
    }
}
