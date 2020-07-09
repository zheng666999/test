package com.background.demo.dao;

import com.background.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserDao {

    public User login(User user);
    public List<User> selectUser(@Param("user_id") int user_id, @Param("password") String password);
    public User findUserById(int user_id);
    public List<User>  selectByPage(@Param("notleave")int  notleave,@Param("end")int  end);
    public int selectToatal();
    public int insertStudent(User user);
    public int deleteStudent(User user);
    public int updateActive(User user);
    public int updateConf(User user);
}
