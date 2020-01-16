package com.gnosed.demo.service;

import com.gnosed.demo.pojo.Book;

import java.util.List;

public interface IBookeService {
    List<Book> list();

    boolean addOrUpdate(Book book);

    void delete(Book book);

    List<Book> listByCategory(int cid);

    List<Book> listByKeyword(String keywords);
}
