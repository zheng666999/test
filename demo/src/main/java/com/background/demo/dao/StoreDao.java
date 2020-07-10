package com.background.demo.dao;


import com.background.demo.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {
    public Store selectById(Store store);
    public Store findStoreById(int store_id);
    public List<Store> selectByPage(@Param("start")int  start, @Param("end")int  end);
    public int selectToatal();
    public int insertStore(Store store);
    public int deleteStore(Store store);
    public int updateActive(Store store);
    public int updateConf(Store store);
}
