package com.sxl.dao;
import java.util.List;
import com.sxl.model.Delete;
public interface DeleteDao {
    List<Delete> queryForList(Delete delete);
    Integer countAll(Delete delete);
    int delete(Long id);
    Delete getById(Long id);
    int update(Delete delete);
    int insert(Delete delete);
}
