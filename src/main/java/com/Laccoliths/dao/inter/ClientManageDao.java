package com.Laccoliths.dao.inter;

import com.Laccoliths.entity.Client;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface ClientManageDao {
    /**
     * 返回客户对象列表
     * @return 客户对象列表
     */
    public List<Client> list();
    /**
     * 返回查询到的客户对象列表
     * @param key: 在jsp表单中的键名
     * @param value: 在jsp表单中的键值
     * @return : 返回查询到的客户对象列表
     */
    public List<Client> search(String key, String value);
    /**
     * 新增客户信息
     * @param client :客户对象
     * @return :返回是否保存完成
     */
    public Integer save(Client client);
    /**
     * 更改客户信息
     * @param client :客户对象
     */
    public Integer update(Client client);

    public List<Client> findByStaffId(String staffId);
}
