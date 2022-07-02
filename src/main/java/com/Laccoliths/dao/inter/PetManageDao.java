package com.Laccoliths.dao.inter;

import com.Laccoliths.entity.Pet;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface PetManageDao {
    /**
     * 返回宠物对象列表
     * @return 宠物对象列表
     */
    public List<Pet> list();
    /**
     * 返回查询到的宠物对象列表
     * @param key: 在jsp表单中的键名
     * @param value: 在jsp表单中的键值
     * @return : 返回查询到的宠物对象列表
     */
    public List<Pet> search(String key, String value);
    /**
     * 新增宠物信息
     * @param pet :宠物对象
     * @return :返回是否保存完成
     */
    public Integer save(Pet pet);
    /**
     * 更改宠物信息
     * @param pet :宠物对象
     */
    public Integer update(Pet pet);

    public List<Pet> findByClientId(String clientId);

    public String findByPetId(String petId);
}
