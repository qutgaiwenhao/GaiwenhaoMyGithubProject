package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//通讯录
public class Txl  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//姓名
private String username;
//邮件地址
private String email;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
public String getEmail() {return email;}
public void setEmail(String email) {this.email = email;}
}