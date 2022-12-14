package com.iweb.dao.impl;

import com.iweb.dao.UserDAO;
import com.iweb.pojo.User;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author XQR
 * @date 2022/8/13 2022/8/13
 * @dsecription 类的描述和介绍
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public boolean login(User user) {
        String sql ="select * from user where username=? and password=?";
        try(Connection c= DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql);
        ){
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
