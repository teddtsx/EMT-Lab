package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ukim.finki.mk.lab1.model.views.BooksByAuthorView;

public interface BooksByAuthorViewRepository extends JpaRepository<BooksByAuthorView, Long> {
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW books_by_author", nativeQuery = true)
    void refreshBooksByAuthorView();
}
