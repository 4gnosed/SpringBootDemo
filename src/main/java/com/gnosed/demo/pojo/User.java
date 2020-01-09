package com.gnosed.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
//使用JPA作为实体类的持久化，默认视同hibernate，忽略以下两个无须的json化属性
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
