package com.background.demo.service;

import com.background.demo.dao.UserDao;
import com.background.demo.entity.Page;
import com.background.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Service
public class UserService {

    @Resource
    UserDao ud;
    public UserService() {}
    public User login(User u){
        return ud.login(u);
    }
    public List<User>  select(int user_id,String password){
        return ud.selectUser(user_id, password);
    }
    public User findUserById(int user_id){
        return ud.findUserById(user_id);
    }
    public List<User>  selectByPage(Page page){
        int offset = page.getPagenum()*page.getPagesize();
        return ud.selectByPage(offset,page.getPagesize());
    }
    public int selectToatal(){
        return ud.selectToatal();
    }
    public boolean insertUser(User user){
        if(ud.insertUser(user)>0){
            return true;
        }
        return false;
    }
    public boolean deleteUser(User user){
        if(ud.deleteUser(user)>0){
            return true;
        }
        return false;
    }
    public boolean updateActive(User user){
        if(ud.updateActive(user)>0){
            return true;
        }
        return false;
    }
    public boolean updateConf(User user){
        if(ud.updateConf(user)>0){
            return true;
        }
        return false;
    }
}
