package com.dao.modle.com.dao;

import com.dao.modle.Book;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements IBook{

    private List<Book> books;


    public BookImpl(){
        books =new ArrayList<>();

        books.add(new Book(1,"java"));
        books.add(new Book(2,"python"));
        books.add(new Book(3,"natlab"));
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book getbyId(int isbn) {
        return books.get(isbn);
    }

    @Override
    public void save(Book book) {

        books.add(book);

    }

    @Override
    public void delete(Book book) {

        books.remove(book);
    }
}
