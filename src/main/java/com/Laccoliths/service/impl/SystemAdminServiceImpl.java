package com.Laccoliths.service.impl;


import com.Laccoliths.dao.inter.SystemAdminDao;
import com.Laccoliths.dao.impl.SystemAdminDaoImpl;
import com.Laccoliths.dto.SystemAdminDto;
import com.Laccoliths.entity.SystemAdmin;
import com.Laccoliths.service.inter.SystemAdminService;
import com.Laccoliths.util.PasswordUtil;

/**
 * @author MSI
 */
public class SystemAdminServiceImpl implements SystemAdminService {

    private final SystemAdminDao systemAdminDao = new SystemAdminDaoImpl();

    /**
     * 密码不正确 -2
     * 密码正确 0
     * 账户不存在 -1
     */
    @Override
    public SystemAdminDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        SystemAdmin systemAdmin = this.systemAdminDao.findByUsername(username);
        SystemAdminDto systemAdminDto = new SystemAdminDto();

        if(systemAdmin == null){
            systemAdminDto.setCode(-1);
        } else {
            // 判断密码和数据库中存储的MD5码是否一致
            boolean isTrue = PasswordUtil.verify(password, systemAdmin.getPassword());
            if(!isTrue){
                systemAdminDto.setCode(-2);
            } else {
                systemAdminDto.setCode(0);
                systemAdminDto.setSystemAdmin(systemAdmin);
            }
        }
        return systemAdminDto;
    }
}
