package com.Laccoliths.service.inter;

import com.Laccoliths.entity.Veterinarian;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface VeterinarianService {
    /**
     * 返回兽医对象列表
     * @return 兽医对象列表
     */
    public List<Veterinarian> list();
    /**
     * 返回查询到的兽医对象列表
     * @param key: 在jsp表单中的键名
     * @param value: 在jsp表单中的键值
     * @return : 返回查询到的兽医对象列表
     */
    public List<Veterinarian> search(String key,String value);
    /**
     * 新增兽医信息
     * @param veterinarian :兽医对象
     */
    public void save(Veterinarian veterinarian);
    /**
     * 更改兽医信息
     * @param veterinarian :兽医对象
     */
    public void update(Veterinarian veterinarian);
    /**
     * 删除兽医信息
     * @param workNumber :删除兽医的编号
     */
    public void delete(String workNumber);
}
