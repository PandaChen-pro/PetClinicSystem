package com.Laccoliths.dao.inter;


import com.Laccoliths.entity.SystemAdmin;

public interface SystemAdminDao {
    /**
     * 通过用户名查找
     * @param username:账户名
     * @return :返回SystemAdmin对象
     */
    public SystemAdmin findByUsername(String username);
}
