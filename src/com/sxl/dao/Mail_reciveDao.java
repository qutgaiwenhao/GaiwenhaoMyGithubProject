package com.sxl.dao;
import java.util.List;
import com.sxl.model.Mail_recive;
public interface Mail_reciveDao {
    List<Mail_recive> queryForList(Mail_recive mail_recive);
    Integer countAll(Mail_recive mail_recive);
    int delete(Long id);
    Mail_recive getById(Long id);
    int update(Mail_recive mail_recive);
    int insert(Mail_recive mail_recive);
}
