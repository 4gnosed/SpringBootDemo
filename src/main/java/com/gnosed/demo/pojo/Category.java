package com.gnosed.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Category {
    private int id;
    private String name;
}
