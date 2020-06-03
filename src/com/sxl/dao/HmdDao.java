package com.sxl.dao;
import java.util.List;
import com.sxl.model.Hmd;
public interface HmdDao {
    List<Hmd> queryForList(Hmd hmd);
    Integer countAll(Hmd hmd);
    int delete(Long id);
    Hmd getById(Long id);
    int update(Hmd hmd);
    int insert(Hmd hmd);
}
