package com.gnosed.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    private String username;
    private String password;
    private String salt;
    private boolean enabled;
}
