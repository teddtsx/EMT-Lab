package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Book;
import ukim.finki.mk.lab1.model.enums.Category;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateBookDto(Long id, String title, String author, String surname, String country, String category, Integer availableCopies) {
    public static UpdateBookDto from(Book book) {
        return new UpdateBookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getAuthor().getSurname(),
                book.getAuthor().getCountry().getName(),
                book.getCategory().name(),
                book.getAvailableCopies()
        );
    }

    public static List<UpdateAuthorDto> from(List<Author> authors) {
        return authors.stream().map(UpdateAuthorDto::from).collect(Collectors.toList());
    }

    public Book toBook(Category category, Author author) {

        return new Book(title, category, author, 1);
    }

}
