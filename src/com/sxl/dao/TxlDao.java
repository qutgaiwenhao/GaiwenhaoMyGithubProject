package com.sxl.dao;
import java.util.List;
import com.sxl.model.Txl;
public interface TxlDao {
    List<Txl> queryForList(Txl txl);
    Integer countAll(Txl txl);
    int delete(Long id);
    Txl getById(Long id);
    int update(Txl txl);
    int insert(Txl txl);
}
