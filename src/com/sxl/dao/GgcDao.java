package com.sxl.dao;
import java.util.List;
import com.sxl.model.Ggc;
public interface GgcDao {
    List<Ggc> queryForList(Ggc ggc);
    Integer countAll(Ggc ggc);
    int delete(Long id);
    Ggc getById(Long id);
    int update(Ggc ggc);
    int insert(Ggc ggc);
}
