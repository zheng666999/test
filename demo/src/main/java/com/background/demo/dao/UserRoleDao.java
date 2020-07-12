package com.background.demo.dao;

import com.background.demo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserRoleDao {
    public int insertUserRole(@Param("user_id") int user_id,@Param("role_id") int role_id);
    public UserRole getUserRole(@Param("user_id") int user_id);
    public int updateUserRole(@Param("user_id") int user_id,@Param("role_id") int role_id);
}
