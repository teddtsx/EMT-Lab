package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.mk.lab1.model.views.BooksInBadConditionView;

public interface BooksInBadConditionViewRepository extends JpaRepository<BooksInBadConditionView, Long> {
}
