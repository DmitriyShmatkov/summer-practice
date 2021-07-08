package ru.example.bookstore.service;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.entity.Comment;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final BookService bookService;

    @Autowired
    public CommentService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Comment> getCommentsByBookId(Long bookId) {
        Book book = bookService.getBookById(bookId);
        List<Comment> comments = new ArrayList<>();
        if (book != null) {
            comments = book.getComments();
        }
        return comments;
    }
}
