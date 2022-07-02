package com.Laccoliths.dao.impl;

import com.Laccoliths.dao.inter.VisitDao;
import com.Laccoliths.entity.Visit;
import com.Laccoliths.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laccoliths
 */
public class VisitDaoImpl implements VisitDao {

    @Override
    public Integer save(Visit visit) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into visit values(?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, visit.getStaffId());
            statement.setString(2, visit.getPetId());
            statement.setString(3, visit.getClientId());
            statement.setString(4, visit.getDate());
            statement.setString(5, visit.getReceptionStaffNumber());
            System.out.println("visitDaoImpl,save,sql:" + sql);
            System.out.println("visitDaoImpl,save,staffname:" + visit.getReceptionStaffNumber());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, null, statement);
        }
        return result;
    }

    @Override
    public List<Visit> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select staff.name,pet.name,pet.varieties,client.name,visit.time,s.name from staff  , pet ,client , visit, staff s where staff.staffnumber = visit.staff_id and pet.id = visit.pet_id and pet.id = visit.pet_id and client.id = visit.client_id and s.staffnumber = visit.receptionStaffNumber";
        PreparedStatement statement = null;
        List<Visit> list = new ArrayList<Visit>();
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                String staffName = rs.getString(1);
                String petName = rs.getString(2);
                String petVariety = rs.getString(3);
                String clientName = rs.getString(4);
                String visitTime = rs.getString(5);
                String receptionStaffName = rs.getString(6);
                list.add(new Visit(staffName, petName, petVariety, clientName, visitTime, receptionStaffName));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, rs, statement);
        }
        return list;
    }

    @Override
    public List<Visit> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select staff.name,pet.name,pet.varieties,client.name,visit.time,s.name from staff  , pet ,client , visit, staff s where staff.staffnumber = visit.staff_id and pet.id = visit.pet_id and pet.id = visit.pet_id and client.id = visit.client_id and s.staffnumber = visit.receptionStaffNumber";
        String keyStatement = null;
        if (key.equals("petName")) {
            keyStatement = " and pet.name ";
        }else if (key.equals("clientName")) {
            keyStatement = " and client.name ";
        }else if (key.equals("visitTime")) {
            keyStatement = " and visit.time ";
        }
        sql = sql + keyStatement + " like '%" + value + "%'";
        PreparedStatement statement = null;
        List<Visit> list = new ArrayList<Visit>();
        ResultSet rs = null;
        System.out.println(sql);
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                String staffName = rs.getString(1);
                String petName = rs.getString(2);
                String petVariety = rs.getString(3);
                String clientName = rs.getString(4);
                String visitTime = rs.getString(5);
                String receptionStaffName = rs.getString(6);
                list.add(new Visit(staffName, petName, petVariety, clientName, visitTime, receptionStaffName));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, null, rs, statement);
        }
        return list;
    }
}
