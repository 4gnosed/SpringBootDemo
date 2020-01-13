package com.gnosed.demo.controller;

import com.gnosed.demo.pojo.Book;
import com.gnosed.demo.service.IBookeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private IBookeService iBookeService;

    @GetMapping("/api/books")
    public List<Book> list() {
        return iBookeService.list();
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
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return iBookeService.listByCategory(cid);
        } else {
            return list();
        }
    }
}
