package ukim.finki.mk.lab1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT * FROM authors_by_country")
@Immutable
public class AuthorsByCountryView {

    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "author_count")
    private Long authorCount;
}
