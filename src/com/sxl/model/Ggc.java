package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//广告或敏感词汇
public class Ggc  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//广告词语
private String username;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
}