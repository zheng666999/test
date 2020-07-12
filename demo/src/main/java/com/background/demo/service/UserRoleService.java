package com.background.demo.service;

import com.background.demo.dao.UserRoleDao;
import com.background.demo.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    public UserRoleDao urd;
    public int insertUserRole(int user_id,int role_id){return urd.insertUserRole(user_id, role_id);}
    public UserRole getUserRole(int user_id){
        return urd.getUserRole(user_id);
    }
    public int updateUserRole(int user_id,@Param("role_id") int role_id){
        return urd.updateUserRole(user_id,role_id);
    }
}
