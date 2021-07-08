DROP TABLE IF EXISTS book_group;


CREATE TABLE book_group
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(10),
    discount INT,
    CHECK (REGEXP_LIKE(name, '[A-Za-z0-9]+'))
);

INSERT INTO book_group (id, name, discount)
VALUES (1, 'Group1', 10),
       (2, 'Group2', 25),
       (3, 'Group3', 15);
