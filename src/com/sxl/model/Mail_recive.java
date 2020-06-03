package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//邮件接收
public class Mail_recive  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//发件人
private String v1;
//标题
private String v2;
//内容
private String v3;
//发送时间
private String v4;
//附件名称
private String v5;
//附件地址
private String v6;
//状态
private Integer status;
//
private String emailId;
//
private Integer isd;
public String getV1() {return v1;}
public void setV1(String v1) {this.v1 = v1;}
public String getV2() {return v2;}
public void setV2(String v2) {this.v2 = v2;}
public String getV3() {return v3;}
public void setV3(String v3) {this.v3 = v3;}
public String getV4() {return v4;}
public void setV4(String v4) {this.v4 = v4;}
public String getV5() {return v5;}
public void setV5(String v5) {this.v5 = v5;}
public String getV6() {return v6;}
public void setV6(String v6) {this.v6 = v6;}
public Integer getStatus() {return status;}
public void setStatus(Integer status) {this.status = status;}
public String getEmailId() {return emailId;}
public void setEmailId(String emailId) {this.emailId = emailId;}
public Integer getIsd() {return isd;}
public void setIsd(Integer isd) {this.isd = isd;}
}