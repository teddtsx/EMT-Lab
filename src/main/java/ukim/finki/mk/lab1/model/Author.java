package ukim.finki.mk.lab1.model;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor

public class Author {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
