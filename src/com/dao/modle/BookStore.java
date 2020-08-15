package com.dao.modle;

import com.dao.modle.com.dao.BookImpl;
import com.dao.modle.com.dao.IBook;

public class BookStore {
    public static void main(String[] args) {
        IBook iBook=new BookImpl();

        for (Book book : iBook.getAll()) {
            System.out.println(book.toString());
        }

        Book book=iBook.getbyId(2);
        book.setName("algorithms");
        iBook.save(book);

        System.out.println(book);

        iBook.delete(book);
        System.out.println(book);



    }
}
