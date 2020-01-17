package com.gnosed.demo.controller;

import com.gnosed.demo.base.AbstractClass;
import com.gnosed.demo.dto.BookDto;
import com.gnosed.demo.pojo.Book;
import com.gnosed.demo.pojo.Category;
import com.gnosed.demo.pojo.Search;
import com.gnosed.demo.service.IBookeService;
import com.gnosed.demo.service.ICategoryService;
import com.gnosed.demo.util.EntityTransfer;
import com.gnosed.demo.util.FileUploadUtil;
import com.gnosed.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController extends AbstractClass {

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

    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file, HttpServletRequest request) {
        return FileUploadUtil.upload(file, request);
    }

    @PostMapping("/api/search")
    public List<Book> searchBooks(@RequestBody Search search) {
        String keywords = search.getKeywords();
        if (StringUtil.isEmpty(keywords)) {
            return iBookeService.list();
        } else {
            return iBookeService.listByKeyword(keywords);
        }
    }

    /**
     * pojo转换到dto
     *
     * @param bookList
     * @return
     */
    private ArrayList<BookDto> transferBook(List<Book> bookList) {
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookList) {
            Category category = iCategoryService.listById(book.getCid());
            bookDtos.add(EntityTransfer.transferBook(category, book));
        }
        return bookDtos;
    }

}
