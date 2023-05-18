package com.springboot.StarterCache.service;

import com.springboot.StarterCache.dto.Book;

public interface BooksSvc {

    Book getBookById(Integer bookId) throws InterruptedException;

}
