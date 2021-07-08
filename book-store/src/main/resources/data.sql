DROP TABLE IF EXISTS book_group;
DROP TABLE IF EXISTS book;


CREATE TABLE book_group
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(10),
    discount INT
);

CREATE TABLE book
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    author        VARCHAR(255),
    title         VARCHAR(255),
    price         DECIMAL,
    book_group_id BIGINT,
    FOREIGN KEY (book_group_id) REFERENCES book_group (id)
);

CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

CREATE TABLE comment
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    body    VARCHAR(255),
    user_id BIGINT,
    book_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (book_id) REFERENCES book (id)

);

INSERT INTO book_group (id, name, discount)
VALUES (1, 'Group1', 10),
       (2, 'Group2', 25),
       (3, 'Group3', 15);

INSERT INTO book (id, author, title, price, book_group_id)
VALUES (1, 'Author 1', 'Book 1', 100, 1),
       (2, 'Author 2', 'Book 2', 500, 1),
       (3, 'Author 3', 'Book 3', 400, 2),
       (4, 'Author 4', 'Book 4', 300, 2),
       (5, 'Author 5', 'Book 5', 200, 3);

INSERT INTO user (id, first_name, last_name)
VALUES (1, 'Ivan', 'Ivanov'),
       (2, 'Oleg', 'Fedorov'),
       (3, 'Alex', 'Petrov');

INSERT INTO comment (id, body, user_id, book_id)
VALUES (1, 'Comment by Ivan', 1, 1),
       (2, 'Comment by Oleg', 2, 1),
       (3, 'Comment by Alex', 3, 2),
       (4, 'Comment by Ivan', 1, 2),
       (5, 'Comment by Oleg', 2, 3),
       (6, 'Comment by Alex', 3, 3),
       (7, 'Comment by Ivan', 1, 4),
       (8, 'Comment by Oleg', 2, 4),
       (9, 'Comment by Alex', 3, 5),
       (10, 'Comment by Ivan', 1, 5);

