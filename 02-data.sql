INSERT INTO country ( name, continent) VALUES
                                           ( 'United States', 'North America'),
                                           ( 'United Kingdom', 'Europe'),
                                           ( 'Germany', 'Europe'),
                                           ( 'France', 'Europe'),
                                           ( 'Japan', 'Asia'),
                                           ( 'Canada', 'North America'),
                                           ( 'Italy', 'Europe'),
                                           ( 'Spain', 'Europe'),
                                           ( 'Sweden', 'Europe'),
                                           ( 'Australia', 'Oceania');

-- Insert Authors
INSERT INTO author ( name, surname, country_id) VALUES
                                                    ( 'Mark', 'Twain', 1),
                                                    ( 'Jane', 'Austen', 2),
                                                    ( 'Johann', 'Goethe', 3),
                                                    ( 'Victor', 'Hugo', 4),
                                                    ( 'Haruki', 'Murakami', 5),
                                                    ( 'Margaret', 'Atwood', 6),
                                                    ( 'Dante', 'Alighieri', 7),
                                                    ( 'Miguel', 'de Cervantes', 8),
                                                    ( 'Astrid', 'Lindgren', 9),
                                                    ( 'Tim', 'Winton', 10);
-- Insert Books
INSERT INTO book (name, category, author_id, available_copies ) VALUES
                                                                    ('The Adventures of Tom Sawyer', 'CLASSICS', 1, 10),
                                                                    ('Pride and Prejudice', 'NOVEL', 2, 15),
                                                                    ('Faust', 'DRAMA', 3, 5),
                                                                    ('Les Misérables', 'HISTORY', 4, 8),
                                                                    ('Kafka on the Shore', 'FANTASY', 5, 12),
                                                                    ('The Handmaid''s Tale', 'THRILLER', 6, 9),
                                                                    ('The Divine Comedy', 'CLASSICS', 7, 4),
                                                                    ('Don Quixote', 'CLASSICS', 8, 6);