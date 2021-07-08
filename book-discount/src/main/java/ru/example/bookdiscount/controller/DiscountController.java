package ru.example.bookdiscount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookdiscount.entity.BookGroup;
import ru.example.bookdiscount.service.DiscountService;

import java.util.List;

@RestController
public class DiscountController {
    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/discount/{bookGroupId}")
    public ResponseEntity<Integer> getDiscount(@PathVariable Long bookGroupId) {
        return new ResponseEntity<>(discountService.getDiscount(bookGroupId), HttpStatus.OK);
    }
}
