package com.gnosed.demo.dto;

import com.gnosed.demo.pojo.Category;
import lombok.Data;

/**
 * @Author Gnosed Lu
 * @Date 2020/1/14
 */
@Data
public class BookDto {
    int id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private Category category;
}
