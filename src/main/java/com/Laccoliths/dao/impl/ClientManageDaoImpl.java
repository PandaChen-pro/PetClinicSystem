package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.ClientManageDao;
import com.Laccoliths.entity.Client;
import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.Veterinarian;
import com.Laccoliths.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laccoliths
 */
public class ClientManageDaoImpl implements ClientManageDao {

    @Override
    public List<Client> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from client";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Client> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String petName = resultSet.getString(5);
                String varieties = resultSet.getString(6);
                String staffName = resultSet.getString(7);
                String isOk = resultSet.getString(8);
                list.add(new Client(id, name, gender,telephone,petName,varieties,staffName,isOk));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public List<Client> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from client where "+ key +" like '%"+ value +"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Client> list = new ArrayList<>();
        System.out.println(sql);
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                String petName = resultSet.getString(5);
                String varieties = resultSet.getString(6);
                String staffName = resultSet.getString(7);
                String isOk = resultSet.getString(8);
                list.add(new Client(id, name, gender,telephone,petName,varieties,staffName,isOk));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public Integer save(Client client) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into client values(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getGender());
            statement.setString(4, client.getTelephone());
            statement.setString(5, client.getPetName());
            statement.setString(6, client.getVarieties());
            statement.setString(7, client.getStaffName());
            statement.setString(8, client.getIsOk());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer update(Client client) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update client set name = ?, gender = ?, telephone = ?, petName = ? , varieties = ?, staffName = ?, isOk = ? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, client.getName());
            statement.setString(2, client.getGender());
            statement.setString(3, client.getTelephone());
            statement.setString(4, client.getPetName());
            statement.setString(5, client.getVarieties());
            statement.setString(6, client.getStaffName());
            statement.setString(7, client.getIsOk());
            statement.setString(8, client.getId());
            System.out.println(client.getPetName());
            System.out.println(client.getStaffName());
            System.out.println(client.getId());
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
    public List<Client> findByStaffId(String staffId) {
        Connection connection = JDBCUtil.getConnection();
        String getStaffNameSql = "select name from staff where staffnumber = '" + staffId + "'";
        Statement stmt = null;
        List<Client> list = new ArrayList<>();
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        try {
            System.out.println(getStaffNameSql);
            stmt = connection.createStatement();
            resultSet1 = stmt.executeQuery(getStaffNameSql);
            while (resultSet1.next()) {
                String getClientNameSql = "select id,name from client where staffName = '" + resultSet1.getString("name") + "'";
                stmt = connection.createStatement();
                System.out.println(getClientNameSql);
                resultSet2 = stmt.executeQuery(getClientNameSql);
                System.out.println(getClientNameSql);
                resultSet2.beforeFirst();
                while (resultSet2.next()) {
                    String id = resultSet2.getString("id");
                    String name = resultSet2.getString("name");
                    list.add(new Client(id,name));
                }
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }finally {
            JDBCUtil.release(connection, stmt, resultSet1, null);
            JDBCUtil.release(null, null, resultSet2, null);
        }
        return list;
    }
}
