package com.Laccoliths.service.impl;

import com.Laccoliths.dao.impl.PetManageDaoImpl;
import com.Laccoliths.dao.inter.PetManageDao;
import com.Laccoliths.entity.Pet;
import com.Laccoliths.service.inter.PetManageService;

import java.util.List;

/**
 * @author Laccoliths
 */
public class PetManageServiceImpl implements PetManageService {

    private final PetManageDao petManageDaoImpl = new PetManageDaoImpl();

    @Override
    public List<Pet> list() {
        return this.petManageDaoImpl.list();
    }

    @Override
    public List<Pet> search(String key, String value) {
        if ("".equals(value)) {
            return this.petManageDaoImpl.list();
        }else {
            return this.petManageDaoImpl.search(key, value);
        }
    }

    @Override
    public void save(Pet pet) {
        Integer result = this.petManageDaoImpl.save(pet);
        if (result != 1) {
            throw new RuntimeException("保存失败");
        }
    }

    @Override
    public void update(Pet pet) {
        Integer result = this.petManageDaoImpl.update(pet);
        if (result != 1) {
            throw new RuntimeException("客户信息修改失败");
        }
    }


    @Override
    public List<Pet> findByClientId(String id) {
        return this.petManageDaoImpl.findByClientId(id);
    }

    @Override
    public String findByPetId(String id) {
        System.out.println("findByPetId:"+ this.petManageDaoImpl.findByPetId(id));
        return this.petManageDaoImpl.findByPetId(id);
    }
}
