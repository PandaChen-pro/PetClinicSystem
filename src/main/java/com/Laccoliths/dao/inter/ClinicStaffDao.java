package com.Laccoliths.dao.inter;

import com.Laccoliths.entity.ClinicStaff;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface ClinicStaffDao {
    public ClinicStaff findUserName(String userName);
    /**
     * 返回职工对象列表
     * @return 职工对象列表
     */
    public List<ClinicStaff> list();
    /**
     * 返回查询到的职员对象列表
     * @param key: 在jsp表单中的键名
     * @param value: 在jsp表单中的键值
     * @return : 返回查询到的职员对象列表
     */
    public List<ClinicStaff> search(String key, String value);
    /**
     * 新增职员信息
     * @param clinicStaff :职员对象
     * @return :返回是否保存完成
     */
    public Integer save(ClinicStaff clinicStaff);
    /**
     * 更改职员信息
     * @param clinicStaff :职员对象
     */
    public Integer update(ClinicStaff clinicStaff);
    /**
     * 删除职员信息
     * @param staffNumber :删除职员的编号
     * @return :返回是否删除完成
     */
    public Integer delete(String staffNumber);
}
