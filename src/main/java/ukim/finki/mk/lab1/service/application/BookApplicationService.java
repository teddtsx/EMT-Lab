package ukim.finki.mk.lab1.service.application;


import ukim.finki.mk.lab1.dto.CreateBookDto;
import ukim.finki.mk.lab1.dto.UpdateBookDto;
import ukim.finki.mk.lab1.model.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
       List<UpdateBookDto> findAll();
       Optional<UpdateBookDto> findById(Long id);
       Optional <UpdateBookDto> save(CreateBookDto createBookDto);
       Optional <UpdateBookDto> edit(UpdateBookDto updateBookDto);
       void deleteById(Long id);
       void markAsTaken(Long id);
   }

