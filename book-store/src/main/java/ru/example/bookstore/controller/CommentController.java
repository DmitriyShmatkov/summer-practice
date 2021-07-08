package ru.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookstore.entity.Comment;
import ru.example.bookstore.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/book/{bookId}/comments")
    public List<Comment> getCommentsByBookId(@PathVariable Long bookId) {
        return commentService.getCommentsByBookId(bookId);
    }

}
