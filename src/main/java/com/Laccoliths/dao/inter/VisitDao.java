package com.Laccoliths.dao.inter;

import com.Laccoliths.entity.Visit;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface VisitDao {
    public Integer save(Visit visit);
    public List<Visit> list();
    public List<Visit> search(String key, String value);
}
