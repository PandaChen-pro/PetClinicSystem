package com.Laccoliths.service.inter;

import com.Laccoliths.entity.Pet;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface PetManageService {
    /**
     * 列举全部宠物信息
     * @return 全部宠物对象列表
     */
    public List<Pet> list();
    /**
     * 查询到的宠物信息
     * @return 查询到的宠物信息
     */
    public List<Pet> search(String key,String value);
    /**
     * 新增宠物信息
     */
    public void save(Pet pet);
    /**
     * 更改宠物信息
     */
    public void update(Pet pet);

    public List<Pet> findByClientId(String id);

    public String findByPetId(String id);
}
