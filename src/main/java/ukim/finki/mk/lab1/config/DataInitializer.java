package ukim.finki.mk.lab1.config;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Country;
import ukim.finki.mk.lab1.model.domain.User;
import ukim.finki.mk.lab1.model.enums.Role;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.repository.CountryRepository;
import ukim.finki.mk.lab1.repository.UserRepository;

import java.util.List;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void initData() {
//        if (countryRepository.count() == 0) { // Avoid duplicates
//            Country canada = new Country("Canada", "North America");
//            Country ireland = new Country("Ireland", "Europe");
//            Country germany = new Country("Germany", "Europe");
//            Country france = new Country("France", "Europe");
//            Country japan = new Country("Japan", "Asia");
//            countryRepository.saveAll(List.of(canada, ireland, germany, france, japan));
//
//        }
//        if (authorRepository.count() == 0) { // Avoid duplicates
//            Country canada = countryRepository.findByName("Canada").orElseThrow();
//            Country ireland = countryRepository.findByName("Ireland").orElseThrow();
//            Country france = countryRepository.findByName("France").orElseThrow();
//
//            Author author1 = new Author("Mark", "Twain", canada);
//            Author author2 = new Author("George", "Orwell", ireland);
//            Author author3 = new Author("Victor", "Hugo", france);
//            Author author4 = new Author("Haruki", "Murakami", countryRepository.findByName("Japan").orElseThrow());
//
//            authorRepository.saveAll(List.of(author1, author2, author3, author4));
//        }

        if (userRepository.count()==0){
            User user1 = new User("admin", passwordEncoder.encode("admin"),"zoran","zoranovic", Role.ROLE_LIBRARIAN);
            User user2 = new User("user", passwordEncoder.encode("user"),"zoc","zocevich", Role.ROLE_USER);
            userRepository.saveAll(List.of(user1, user2));
        }

    }

}
