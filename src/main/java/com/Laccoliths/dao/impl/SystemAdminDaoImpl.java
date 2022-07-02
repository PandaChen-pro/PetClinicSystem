package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.SystemAdminDao;
import com.Laccoliths.entity.SystemAdmin;
import com.Laccoliths.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemAdminDaoImpl implements SystemAdminDao {

    /**
     * 查询id,username,password,name,telephone
     * @param username:账户名
     * @return 带属性的Admin对象：id,username,password,name,telephone
     */
    @Override
    public SystemAdmin findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from systemadmin where username = '"+username+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                username = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new SystemAdmin(name,username,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return null;
    }
}
