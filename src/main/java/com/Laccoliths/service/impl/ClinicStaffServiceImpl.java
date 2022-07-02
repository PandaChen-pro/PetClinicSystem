package com.Laccoliths.service.impl;

import com.Laccoliths.dao.impl.ClinicStaffDaoImpl;
import com.Laccoliths.dao.inter.ClinicStaffDao;
import com.Laccoliths.dto.ClinicStaffDto;
import com.Laccoliths.dto.SystemAdminDto;
import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.SystemAdmin;
import com.Laccoliths.service.inter.ClinicStaffService;
import com.Laccoliths.util.PasswordUtil;

import java.util.List;

/**
 * @author Laccoliths
 */
public class ClinicStaffServiceImpl implements ClinicStaffService {
    private final ClinicStaffDao clinicStaffDaoImpl = new ClinicStaffDaoImpl();

    @Override
    public ClinicStaffDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        ClinicStaff clinicStaff = this.clinicStaffDaoImpl.findUserName(username);
        ClinicStaffDto clinicStaffDto = new ClinicStaffDto();

        if(clinicStaff == null){
            clinicStaffDto.setCode(-1);
        } else {
            // 判断密码和数据库中存储的MD5码是否一致
            boolean isTrue = PasswordUtil.verify(password, clinicStaff.getPassword());
            if(!isTrue){
                clinicStaffDto.setCode(-2);
            } else {
                clinicStaffDto.setCode(0);
                clinicStaffDto.setClinicStaff(clinicStaff);
            }
        }
        return clinicStaffDto;
    }

    @Override
    public List<ClinicStaff> list() {
        return this.clinicStaffDaoImpl.list();
    }

    @Override
    public List<ClinicStaff> search(String key, String value) {
        if ("".equals(value)){
            return this.clinicStaffDaoImpl.list();
        }else{
            return this.clinicStaffDaoImpl.search(key, value);
        }
    }

    @Override
    public void save(ClinicStaff clinicStaff) {
        Integer result = clinicStaffDaoImpl.save(clinicStaff);
        if (result != 1) {
            throw new RuntimeException("职员信息添加失败");
        }
    }

    @Override
    public void update(ClinicStaff clinicStaff) {
        Integer result = clinicStaffDaoImpl.update(clinicStaff);
        if (result != 1){
            throw new RuntimeException("更改职员信息失败");
        }
    }

    @Override
    public void delete(String staffnumber) {
        Integer result = clinicStaffDaoImpl.delete(staffnumber);
        if (result != 1){
            throw new RuntimeException("更改职员信息失败");
        }
    }
}
