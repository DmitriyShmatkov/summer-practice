package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.repository.BookRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    @Autowired
    public BookService(BookRepository bookRepository, DiscountService discountService) {
        this.bookRepository = bookRepository;
        this.discountService = discountService;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll().stream()
                .peek(book -> book.setPrice(Math.round(book.getPrice() * (1 - discountService.getDiscount(book.getBookGroup().getId()) / 100.0) * 100) / 100.0))
                .collect(Collectors.toList());
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
            book.setPrice(Math.round(book.getPrice() * (1 - discountService.getDiscount(book.getBookGroup().getId()) / 100.0) * 100) / 100.0);
        } else {
            book = null;
        }
        return book;
    }
}
