package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.ClinicStaffDao;
import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.SystemAdmin;
import com.Laccoliths.util.PasswordUtil;
import com.Laccoliths.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laccoliths
 */
public class ClinicStaffDaoImpl implements ClinicStaffDao {

    /**
     * 登录时根据用户名查询用户信息
     * @param userName 用户名
     * @return Staff职工对象
     */
    @Override
    public ClinicStaff findUserName(String userName) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select name,username,password from staff where username = '"+userName+"'";
        System.out.println("ClinicStaff findUserName(String userName) sql: "+sql);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new ClinicStaff(name,userName,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return null;
    }

    @Override
    public List<ClinicStaff> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from staff";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ClinicStaff> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String username = resultSet.getString(5);
                String password = resultSet.getString(6);
                list.add(new ClinicStaff(id,name,gender,telephone,username,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public List<ClinicStaff> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from staff where "+ key +" like '%"+ value +"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ClinicStaff> list = new ArrayList<>();
        System.out.println(sql);
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String username = resultSet.getString(5);
                String password = resultSet.getString(6);
                list.add(new ClinicStaff(id,name,gender,telephone,username,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public Integer save(ClinicStaff clinicStaff) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into staff values(?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, clinicStaff.getNumber());
            statement.setString(2, clinicStaff.getName());
            statement.setString(3, clinicStaff.getGender());
            statement.setString(4, clinicStaff.getTelephone());
            statement.setString(5, clinicStaff.getUsername());
            statement.setString(6, PasswordUtil.generate(clinicStaff.getPassword()));
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer update(ClinicStaff clinicStaff) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update staff set name = ?, gender = ?, telephone = ?, username = ?, password = ? where staffnumber=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, clinicStaff.getName());
            statement.setString(2, clinicStaff.getGender());
            statement.setString(3, clinicStaff.getTelephone());
            statement.setString(4, clinicStaff.getUsername());
            statement.setString(5, PasswordUtil.generate(clinicStaff.getPassword()));
            statement.setString(6, clinicStaff.getNumber());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer delete(String staffNumber) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from staff where staffnumber = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, staffNumber);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }
}
