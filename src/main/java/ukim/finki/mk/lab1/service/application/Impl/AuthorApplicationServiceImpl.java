package ukim.finki.mk.lab1.service.application.Impl;

import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.model.domain.Country;
import ukim.finki.mk.lab1.service.application.AuthorApplicationService;
import ukim.finki.mk.lab1.service.domain.AuthorService;
import ukim.finki.mk.lab1.service.domain.CountryService;

import java.util.List;
import java.util.Optional;

public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final CountryService countryService;
    private final AuthorService authorService;

    public AuthorApplicationServiceImpl(CountryService countryService, AuthorService authorService) {

        this.countryService = countryService;
        this.authorService = authorService;
    }

    @Override
    public List<UpdateAuthorDto> findAll() {
        return UpdateAuthorDto.from(authorService.findAll());
    }

    @Override
    public Optional<UpdateAuthorDto> findById(Long id) {
        return authorService.findById(id).map(UpdateAuthorDto::from);
    }

    @Override
    public Optional<UpdateAuthorDto> save(CreateAuthorDto createAuthorDto) {

        return authorService.save(createAuthorDto).map(UpdateAuthorDto::from);
    }

    @Override
    public Optional<UpdateAuthorDto> edit(UpdateAuthorDto updateAuthorDto  ) {
        return authorService.edit(updateAuthorDto).map(UpdateAuthorDto::from);
    }

    @Override
    public void deleteById(Long id) {

    }
}
