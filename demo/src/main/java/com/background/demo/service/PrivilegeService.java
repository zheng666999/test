package com.background.demo.service;

import com.background.demo.dao.PrivilegeDao;
import com.background.demo.entity.Pivilege;
import com.background.demo.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeService {
    @Resource
    PrivilegeDao pd;

    public PrivilegeService() {
    }
    public List<Pivilege> selectAll(){
        return pd.selectAll();
    }

    public List<Role> selectRole(){
        return pd.selectRole();
    }
    public List<Pivilege> selectRolePri(int role_id){
        return pd.selectRolePri(role_id);
    }
    public int insertPriv(int role_id ,int privilege_id){
        return pd.insertPriv(role_id,privilege_id);
    }
    public int deletePriv(int role_id ,int privilege_id){
        return pd.deletePriv(role_id,privilege_id);
    }

}
