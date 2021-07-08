package ru.example.bookstore.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;

@Service
public class DiscountService {

    public Integer getDiscount(Long bookGroupId) {
        Integer discount;
        try {
            ResponseEntity<Integer> responseEntity = new RestTemplate().getForEntity
                    ("http://localhost:8081/discount/" + bookGroupId, Integer.class);
            discount = responseEntity.getBody();
        } catch (RestClientException e) {
            discount = 0;   // returning 0 discount if service is unavailable
        }
       return discount;
    }
}
