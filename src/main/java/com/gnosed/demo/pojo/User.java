package com.gnosed.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
//使用JPA简化数据库操作，默认使用hibernate，实体类会被代理类继承并添加以下两个无须的属性，转化成Json对象，因此可以忽略
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String username;
    private String password;
}
