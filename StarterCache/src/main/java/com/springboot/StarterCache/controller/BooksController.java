package com.springboot.StarterCache.controller;

import com.springboot.StarterCache.dto.Book;
import com.springboot.StarterCache.service.BooksSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksSvcImpl booksSvcImpl;

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) throws InterruptedException {

        Book book = booksSvcImpl.getBookById(bookId);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
