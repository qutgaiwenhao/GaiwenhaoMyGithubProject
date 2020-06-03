package com.sxl.dao;
import java.util.List;
import com.sxl.model.Mail_send;
public interface Mail_sendDao {
    List<Mail_send> queryForList(Mail_send mail_send);
    Integer countAll(Mail_send mail_send);
    int delete(Long id);
    Mail_send getById(Long id);
    int update(Mail_send mail_send);
    int insert(Mail_send mail_send);
}
