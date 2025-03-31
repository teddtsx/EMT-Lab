package ukim.finki.mk.lab1.service.application;

import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<UpdateAuthorDto> findAll();
    Optional<UpdateAuthorDto> findById(Long id);
    Optional <UpdateAuthorDto> save(CreateAuthorDto createAuthorDto);
    Optional <UpdateAuthorDto> edit(UpdateAuthorDto updateAuthorDto);
    void deleteById(Long id);
}
