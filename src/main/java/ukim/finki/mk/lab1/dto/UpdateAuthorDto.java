package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateAuthorDto(Long id, String name, String surname, Long country) {
    public static UpdateAuthorDto from(Author author) {
        return  new UpdateAuthorDto(author.getId(),author.getName(),author.getSurname(),author.getCountry().getId());
    }
    public static List<UpdateAuthorDto> from(List<Author> categories) {
        return categories.stream().map(UpdateAuthorDto::from).collect(Collectors.toList());
    }

}
