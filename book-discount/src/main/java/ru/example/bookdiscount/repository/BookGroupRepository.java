package ru.example.bookdiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookdiscount.entity.BookGroup;

@Repository
public interface BookGroupRepository extends JpaRepository<BookGroup, Long> {
}
