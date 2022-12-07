package com.example.myCoolBookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.myCoolBookstore.entity.Book;
import com.example.myCoolBookstore.entity.Category;
import com.example.myCoolBookstore.service.BookService;
import com.example.myCoolBookstore.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @RequestMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();

        model.addAttribute("books", books);
        return "/books/allBooks";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);

        model.addAttribute("book", book);
        return "/books/bookById";
    }

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("categories", categories);
        return "books/categories";
    }

    @GetMapping("/categories/{category}")
    public String getBooksByCategory(@PathVariable String category, Model model) {
        List<Book> books = bookService.getBooksByCategory(category);

        model.addAttribute("books", books);
        model.addAttribute("chosen_category", category);
        return "/books/booksByCategory";
    }
}