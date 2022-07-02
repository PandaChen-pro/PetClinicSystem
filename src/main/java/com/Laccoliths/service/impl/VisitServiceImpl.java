package com.Laccoliths.service.impl;

import com.Laccoliths.dao.impl.VisitDaoImpl;
import com.Laccoliths.dao.inter.VisitDao;
import com.Laccoliths.entity.Visit;
import com.Laccoliths.service.inter.VisitService;

import java.util.List;

/**
 * @author Laccoliths
 */
public class VisitServiceImpl implements VisitService {

    private VisitDao visitDao = new VisitDaoImpl();

    @Override
    public void save(Visit visit) {
        Integer result = visitDao.save(visit);
        if (result != 1) {
            throw new RuntimeException("保存失败");
        }
    }

    @Override
    public List<Visit> list() {
        return visitDao.list();
    }

    @Override
    public List<Visit> search(String key, String value) {
        return visitDao.search(key, value);
    }
}
