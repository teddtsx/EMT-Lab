CREATE TABLE country (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         continent VARCHAR(255) NOT NULL
);

CREATE TABLE author (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        surname VARCHAR(255) NOT NULL,
                        country_id BIGINT REFERENCES country(id)
);

CREATE TABLE book (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      category VARCHAR(50) NOT NULL,
                      author_id BIGINT REFERENCES author(id),
                      available_copies INT NOT NULL
);

CREATE TABLE wish_users (
                            username VARCHAR(255) PRIMARY KEY,
                            password VARCHAR(255) NOT NULL,
                            name VARCHAR(255) NOT NULL,
                            surname VARCHAR(255) NOT NULL,
                            role VARCHAR(50) NOT NULL

);

CREATE TABLE wishlists (
                           id BIGSERIAL PRIMARY KEY,
                           user_id VARCHAR(255) UNIQUE REFERENCES wish_users(username),
                           name VARCHAR(255)
);

CREATE TABLE wishlists_books (
                                 wishlist_id BIGINT REFERENCES wishlists(id) ON DELETE CASCADE,
                                 book_id BIGINT REFERENCES book(id) ON DELETE CASCADE,
                                 PRIMARY KEY (wishlist_id, book_id)
);
