package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.projections.AuthorProjection;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long>{
   // List<AuthorProjection> findByName();

    @Query("select a.name, a.surname from Author a")
    List<AuthorProjection> findAuthorProjections();
}
