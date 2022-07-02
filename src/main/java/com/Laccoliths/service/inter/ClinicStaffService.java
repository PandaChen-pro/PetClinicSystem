package com.Laccoliths.service.inter;

import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.dto.ClinicStaffDto;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface ClinicStaffService {
    public ClinicStaffDto login(String username, String password);
    /**
     * 列举全部职员信息
     * @return 全部职员对象列表
     */
    public List<ClinicStaff> list();
    /**
     * 查询到的职员信息
     * @return 查询到的职员信息
     */
    public List<ClinicStaff> search(String key,String value);
    /**
     * 新增职员信息
     */
    public void save(ClinicStaff clinicStaff);
    /**
     * 更改职员信息
     */
    public void update(ClinicStaff clinicStaff);
    /**
     * 删除职员信息
     */
    public void delete(String staffnumber);
}
