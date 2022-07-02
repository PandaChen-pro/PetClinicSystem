package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.VeterinarianDao;
import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.Veterinarian;
import com.Laccoliths.util.JDBCUtil;
import com.Laccoliths.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laccoliths
 */
public class VeterinarianDaoImpl implements VeterinarianDao {

    @Override
    public List<Veterinarian> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from veterinarian";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Veterinarian> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String workNumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String speciality = resultSet.getString(5);
                list.add(new Veterinarian(workNumber,name,gender,telephone,speciality));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public List<Veterinarian> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from veterinarian where "+ key +" like '%"+ value +"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Veterinarian> list = new ArrayList<>();
        System.out.println(sql);
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String workNumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String speciality = resultSet.getString(5);
                list.add(new Veterinarian(workNumber,name,gender,telephone,speciality));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public Integer save(Veterinarian veterinarian) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into veterinarian values(?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, veterinarian.getWorkNumber());
            statement.setString(2, veterinarian.getName());
            statement.setString(3, veterinarian.getGender());
            statement.setString(4, veterinarian.getTelephone());
            statement.setString(5, veterinarian.getSpeciality());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer update(Veterinarian veterinarian) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update veterinarian set name = ?, gender = ?, telephone = ?, speciality = ? where worknumber=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, veterinarian.getName());
            statement.setString(2, veterinarian.getGender());
            statement.setString(3, veterinarian.getTelephone());
            statement.setString(4, veterinarian.getSpeciality());
            statement.setString(5, veterinarian.getWorkNumber());
            System.out.println(veterinarian.getWorkNumber());
            System.out.println(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer delete(String workNumber) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from veterinarian where worknumber = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, workNumber);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }
}
