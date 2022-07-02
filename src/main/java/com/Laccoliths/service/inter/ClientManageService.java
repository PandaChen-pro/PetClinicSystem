package com.Laccoliths.service.inter;

import com.Laccoliths.entity.Client;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface ClientManageService {
    /**
     * 列举全部客户信息
     * @return 全部客户对象列表
     */
    public List<Client> list();
    /**
     * 查询到的客户信息
     * @return 查询到的客户信息
     */
    public List<Client> search(String key,String value);
    /**
     * 新增客户信息
     */
    public void save(Client client);
    /**
     * 更改客户信息
     */
    public void update(Client client);

    public List<Client> findByStaffId(String id);

}
