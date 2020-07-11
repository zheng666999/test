package com.background.demo.dao;

import com.background.demo.entity.Pivilege;
import com.background.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegeDao {
    public List<Pivilege> selectAll();
    public List<Role> selectRole();
    public List<Pivilege> selectRolePri(@Param("role_id") int role_id);
    public int insertPriv(@Param("role_id") int role_id,@Param("privilege_id") int privilege_id);
    public int deletePriv(@Param("role_id") int role_id,@Param("privilege_id") int privilege_id);
}
