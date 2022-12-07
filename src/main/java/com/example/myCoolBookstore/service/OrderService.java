package com.example.myCoolBookstore.service;

import org.springframework.stereotype.Service;
import com.example.myCoolBookstore.entity.Book;
import com.example.myCoolBookstore.entity.Order;
import com.example.myCoolBookstore.repo.BookRepository;
import com.example.myCoolBookstore.repo.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public OrderService(OrderRepository orderRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        Book book = bookRepository.findById(order.getBook().getId()).get();

        if (book.getAvailable() > 0) {
            book.setAvailable(book.getAvailable() - 1);
            orderRepository.save(order);
        } else {
            throw new IllegalStateException("No such books left");
        }
    }
}