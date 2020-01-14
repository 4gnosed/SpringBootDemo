package com.gnosed.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gnosed.demo.constant.Constant;
import com.gnosed.demo.mapper.CategoryMapper;
import com.gnosed.demo.pojo.Category;
import com.gnosed.demo.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * @Author Gnosed Lu
 * @Date 2020/1/14
 */
@Service
public class ICategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Override
    public Category listById(int cid) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.ID, cid);
        return list(queryWrapper).get(0);
    }
}
