package com.gnosed.demo.controller;

import com.gnosed.demo.dto.BookDto;
import com.gnosed.demo.pojo.Book;
import com.gnosed.demo.pojo.Category;
import com.gnosed.demo.service.IBookeService;
import com.gnosed.demo.service.ICategoryService;
import com.gnosed.demo.util.EntityTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private IBookeService iBookeService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/api/books")
    public List<BookDto> list() {
        List<Book> bookList = iBookeService.list();
        return transferBook(bookList);
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        iBookeService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        iBookeService.delete(book);
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<BookDto> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            List<Book> bookList = iBookeService.listByCategory(cid);
            return transferBook(bookList);
        } else {
            return list();
        }
    }

    private ArrayList<BookDto> transferBook(List<Book> bookList) {
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookList) {
            Category category = iCategoryService.listById(book.getCid());
            bookDtos.add(EntityTransfer.transferBook(category, book));
        }
        return bookDtos;
    }
}
