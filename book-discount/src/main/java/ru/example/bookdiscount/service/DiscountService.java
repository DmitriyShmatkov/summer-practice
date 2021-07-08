package ru.example.bookdiscount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookdiscount.entity.BookGroup;
import ru.example.bookdiscount.repository.BookGroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    private final BookGroupRepository bookGroupRepository;

    @Autowired
    public DiscountService(BookGroupRepository bookGroupRepository) {
        this.bookGroupRepository = bookGroupRepository;
    }

    public Integer getDiscount(Long bookGroupId) {
        Optional<BookGroup> optionalBookGroup = bookGroupRepository.findById(bookGroupId);
        return optionalBookGroup.map(BookGroup::getDiscount).orElse(0);
    }
}
