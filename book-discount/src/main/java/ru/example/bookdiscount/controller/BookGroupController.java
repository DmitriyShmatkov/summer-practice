package ru.example.bookdiscount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookdiscount.entity.BookGroup;
import ru.example.bookdiscount.service.BookGroupService;

import java.util.List;

@RestController
public class BookGroupController {

    private final BookGroupService bookGroupService;

    @Autowired
    public BookGroupController(BookGroupService bookGroupService) {
        this.bookGroupService = bookGroupService;
    }

    @GetMapping("/groups")
    public List<BookGroup> getBookGroups() {
        return bookGroupService.getBookGroups();
    }
}
