package com.gnosed.demo.pojo;

import lombok.Data;

@Data
public class Book {
    int id;
    private Category category;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
}
