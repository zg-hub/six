package com.dao.modle.com.dao;

import com.dao.modle.Book;

import java.util.List;

public interface IBook {

    List<Book> getAll();

    Book getbyId(int isbn);

    void save(Book book);
    void delete(Book book);



}
