package com.gnosed.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private int cid;
}
