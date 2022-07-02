package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.PetManageDao;
import com.Laccoliths.entity.Client;
import com.Laccoliths.entity.Pet;
import com.Laccoliths.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laccoliths
 */
public class PetManageDaoImpl implements PetManageDao {
    @Override
    public List<Pet> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from pet";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Pet> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String age = resultSet.getString("age");
                String varieties = resultSet.getString("varieties");
                String symptom = resultSet.getString("symptom");
                String isCure = resultSet.getString("isCure");
                String clientName = resultSet.getString("clientName");
                String doctorName = resultSet.getString("doctorName");
                System.out.println(clientName);
                System.out.println(doctorName);
                list.add(new Pet(id, name, gender,age,varieties,symptom,isCure,clientName,doctorName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public List<Pet> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from pet where "+ key +" like '%"+ value +"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Pet> list = new ArrayList<>();
        System.out.println(sql);
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String age = resultSet.getString("age");
                String varieties = resultSet.getString("varieties");
                String symptom = resultSet.getString("symptom");
                String isCure = resultSet.getString("isCure");
                String clientName = resultSet.getString("clientName");
                String doctorName = resultSet.getString("doctorName");
                list.add(new Pet(id, name, gender,age,varieties,symptom,isCure,clientName,doctorName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, resultSet, statement);
        }
        return list;
    }

    @Override
    public Integer save(Pet pet) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into pet values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pet.getId());
            statement.setString(2, pet.getName());
            statement.setString(3, pet.getGender());
            statement.setString(4, pet.getAge());
            statement.setString(5, pet.getVarieties());
            statement.setString(6, pet.getSymptom());
            statement.setString(7, pet.getIsCure());
            statement.setString(8, pet.getClientName());
            statement.setString(9, pet.getDoctorName());
            System.out.println("pet,save"+pet.getClientName());
            System.out.println("pet,save"+pet.getDoctorName());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public Integer update(Pet pet) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update pet set name = ?, gender = ?, age = ?, varieties = ? , symptom = ?, isCure = ?, clientname = ? , doctorname = ? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, pet.getName());
            statement.setString(2, pet.getGender());
            statement.setString(3, pet.getAge());
            statement.setString(4, pet.getVarieties());
            statement.setString(5, pet.getSymptom());
            statement.setString(6, pet.getIsCure());
            statement.setString(7, pet.getClientName());
            statement.setString(8, pet.getDoctorName());
            statement.setString(9, pet.getId());
            System.out.println(pet.getClientName());
            System.out.println(pet.getDoctorName());
            System.out.println(pet.getIsCure());
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
    public List<Pet> findByClientId(String clientId) {
        Connection connection = JDBCUtil.getConnection();
        String getClientNameSql = "select name from client where id = '" + clientId + "'";
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Pet> list = new ArrayList<>();
        System.out.println("getClientNameSql："+getClientNameSql);
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(getClientNameSql);
            while (rs.next()) {
                String getPetNameAndVarietySql = "select id,name,varieties from pet where clientname = '" + rs.getString("name") + "'";
                System.out.println("getPetNameAndVarietySql："+getPetNameAndVarietySql);
                stmt = connection.createStatement();
                rs2 = stmt.executeQuery(getPetNameAndVarietySql);
                rs2.beforeFirst();

                while (rs2.next()) {
                    String id = rs2.getString("id");
                    String name = rs2.getString("name");
                    String varieties = rs2.getString("varieties");
                    System.out.println("petManageDaoImpl,findByClientId,id："+id);
                    System.out.println("petManageDaoImpl,findByClientId,name："+name);
                    System.out.println("petManageDaoImpl,findByClientId,varieties："+varieties);
                    list.add(new Pet(id, name, varieties));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, stmt, rs, null);
            JDBCUtil.release(null,null,rs2, null);
        }
        return list;
    }

    @Override
    public String findByPetId(String petId) {
        Connection connection = JDBCUtil.getConnection();
        String getPetVarietySql = "select varieties from pet where id = '" + petId + "'";
        System.out.println(getPetVarietySql);
        Statement stmt = null;
        ResultSet rs = null;
        String variety = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(getPetVarietySql);
            while (rs.next()) {
                variety = rs.getString("varieties");
            }
            return variety;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, stmt, rs, null);
        }
    }
}
