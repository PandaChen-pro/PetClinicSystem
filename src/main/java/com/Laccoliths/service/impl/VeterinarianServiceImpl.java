package com.Laccoliths.service.impl;

import com.Laccoliths.dao.impl.VeterinarianDaoImpl;
import com.Laccoliths.dao.inter.VeterinarianDao;
import com.Laccoliths.entity.Veterinarian;
import com.Laccoliths.service.inter.VeterinarianService;

import java.util.List;

/**
 * @author Laccoliths
 */
public class VeterinarianServiceImpl implements VeterinarianService {

    private final VeterinarianDao veterinarianDaoImpl = new VeterinarianDaoImpl();

    @Override
    public List<Veterinarian> list() {
        return this.veterinarianDaoImpl.list();
    }

    @Override
    public List<Veterinarian> search(String key, String value) {
        if ("".equals(value)){
            return this.veterinarianDaoImpl.list();
        }else{
            return this.veterinarianDaoImpl.search(key, value);
        }
    }

    @Override
    public void save(Veterinarian veterinarian) {
        Integer result = veterinarianDaoImpl.save(veterinarian);
        if (result != 1) {
            throw new RuntimeException("兽医信息添加失败");
        }
    }

    @Override
    public void update(Veterinarian veterinarian) {
        Integer result = veterinarianDaoImpl.update(veterinarian);
        if (result != 1) {
            throw new RuntimeException("兽医信息添加失败");
        }
    }

    @Override
    public void delete(String workNumber) {
        Integer result = veterinarianDaoImpl.delete(workNumber);
        if (result != 1) {
            throw new RuntimeException("兽医信息删除失败");
        }
    }
}
