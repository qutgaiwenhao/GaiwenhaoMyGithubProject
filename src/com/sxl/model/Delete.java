package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//
public class Delete  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//
private String emailId;
//
private String title;
//
private Integer isd;
public String getEmailId() {return emailId;}
public void setEmailId(String emailId) {this.emailId = emailId;}
public String getTitle() {return title;}
public void setTitle(String title) {this.title = title;}
public Integer getIsd() {return isd;}
public void setIsd(Integer isd) {this.isd = isd;}
}