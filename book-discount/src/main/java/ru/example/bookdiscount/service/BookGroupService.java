package ru.example.bookdiscount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookdiscount.entity.BookGroup;
import ru.example.bookdiscount.repository.BookGroupRepository;

import java.util.List;

@Service
public class BookGroupService {

    private final BookGroupRepository bookGroupRepository;

    @Autowired
    public BookGroupService(BookGroupRepository bookGroupRepository) {
        this.bookGroupRepository = bookGroupRepository;
    }

    public List<BookGroup> getBookGroups() {
        return bookGroupRepository.findAll();
    }
}
