package com.codegym.service;

import com.codegym.model.Book;

public interface BookService {
    Iterable<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void remove(Long id);
}
