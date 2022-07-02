package com.Laccoliths.service.impl;

import com.Laccoliths.dao.impl.ClientManageDaoImpl;
import com.Laccoliths.dao.inter.ClientManageDao;
import com.Laccoliths.entity.Client;
import com.Laccoliths.service.inter.ClientManageService;

import java.util.List;

/**
 * @author Laccoliths
 */
public class ClientManageServiceImpl implements ClientManageService {

    private final ClientManageDao clientManageDaoImpl = new ClientManageDaoImpl();

    @Override
    public List<Client> list() {
        return this.clientManageDaoImpl.list();
    }

    @Override
    public List<Client> search(String key, String value) {
        if ("".equals(value)){
            return this.clientManageDaoImpl.list();
        }else{
            return this.clientManageDaoImpl.search(key, value);
        }
    }

    @Override
    public void save(Client client) {
        Integer result = clientManageDaoImpl.save(client);
        if (result != 1) {
            throw new RuntimeException("客户信息添加失败");
        }
    }

    @Override
    public void update(Client client) {
        Integer result = clientManageDaoImpl.update(client);
        if (result != 1) {
            throw new RuntimeException("客户信息修改失败");
        }
    }

    @Override
    public List<Client> findByStaffId(String id){
        return this.clientManageDaoImpl.findByStaffId(id);
    }


}
