package com.Laccoliths.service.inter;

import com.Laccoliths.entity.Visit;

import java.util.List;

/**
 * @author Laccoliths
 */
public interface VisitService {
    public void save(Visit visit);
    public List<Visit> list();
    public List<Visit> search(String key, String value);
}
