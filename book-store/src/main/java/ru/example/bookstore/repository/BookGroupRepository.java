package ru.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookstore.entity.BookGroup;

@Repository
public interface BookGroupRepository extends JpaRepository<BookGroup, Long> {
}
