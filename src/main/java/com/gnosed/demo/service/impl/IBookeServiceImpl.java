package com.gnosed.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gnosed.demo.constant.Constant;
import com.gnosed.demo.mapper.BookMapper;
import com.gnosed.demo.pojo.Book;
import com.gnosed.demo.service.IBookeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class IBookeServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookeService {

    @Override
    public List<Book> list() {
        return list(null);
    }

    @Override
    public boolean addOrUpdate(Book book) {
        return saveOrUpdate(book);
    }

    @Override
    public void delete(Book book) {
        removeById(book.getId());
    }

    @Override
    public List<Book> listByCategory(int cid) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.CID, cid);
        return list(queryWrapper);
    }
}
