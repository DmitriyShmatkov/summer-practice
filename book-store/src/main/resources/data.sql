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
    author        VARCHAR(250),
    title         VARCHAR(250),
    price         DECIMAL,
    book_group_id INT,
    FOREIGN KEY (book_group_id) REFERENCES book_group (id)
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
