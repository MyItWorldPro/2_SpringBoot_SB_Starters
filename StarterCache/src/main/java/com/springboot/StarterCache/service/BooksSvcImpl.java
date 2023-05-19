package com.springboot.StarterCache.service;

import com.springboot.StarterCache.dto.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksSvcImpl implements BooksSvc{

    @Override
    @CachePut(value = "my-book-cache", key = "#bookId", condition = "#bookId==2")
    @Cacheable(value = "my-book-cache", key = "#bookId", unless = "#result==null")
    public Book getBookById(Integer bookId) throws InterruptedException {
        //Mock the DB calls slow time
        Thread.sleep(5000);

        List<Book> booksList = new ArrayList<>();

        Book book1 = new Book(1, "book 1", "author 1");
        Book book2 = new Book(2, "book 2", "author 2");
        Book book3 = new Book(3, "book 3", "author 3");
        Book book4 = new Book(4, "book 4", "author 4");
        Book book5 = new Book(5, "book 5", "author 5");

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);
        booksList.add(book5);

        Book searchedBook = booksList.stream()
                .filter(book -> book.getBookId().equals(bookId))
                .findFirst().orElse(null);

        System.out.println("searchedBook="+searchedBook);

        return searchedBook;
    }

}
