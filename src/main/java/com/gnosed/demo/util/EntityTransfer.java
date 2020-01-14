package com.gnosed.demo.util;

import com.gnosed.demo.dto.BookDto;
import com.gnosed.demo.pojo.Book;
import com.gnosed.demo.pojo.Category;

/**
 * @Author Gnosed Lu
 * @Date 2020/1/14
 */
public class EntityTransfer {
    public static BookDto transferBook(Category category, Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setCategory(category);
        bookDto.setCover(book.getCover());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setDate(book.getDate());
        bookDto.setPress(book.getPress());
        bookDto.setAbs(book.getAbs());
        return bookDto;
    }
}
