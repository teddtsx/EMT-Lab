package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Book;
import ukim.finki.mk.lab1.model.enums.Category;

import java.util.List;

public record CreateBookDto(String title, String author, String surname, String country,String category, Integer availableCopies) {
 public static CreateBookDto from(Book book){
        return new CreateBookDto(book.getTitle(), book.getAuthor().getName(), book.getAuthor().getSurname(), book.getAuthor().getCountry().getName(), book.getCategory().name(), book.getAvailableCopies());
 }

 public static List<CreateBookDto> from(List<Book> books){
     return books.stream().map(CreateBookDto::from).toList();
 }

 public Book toBook(Category category, Author author){
        return new Book(title, category, author, 1);
 }
}
