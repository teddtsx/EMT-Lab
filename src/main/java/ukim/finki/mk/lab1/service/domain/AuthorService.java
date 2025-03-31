package ukim.finki.mk.lab1.service.domain;

import aj.org.objectweb.asm.commons.Remapper;
import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Country;


import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(CreateAuthorDto createAuthorDto);

    Optional<Author> edit(UpdateAuthorDto updateAuthorDto);

    void deleteById(Long id);

}
