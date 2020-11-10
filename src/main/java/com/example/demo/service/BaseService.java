package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> getAll(int pageNum);
    Optional<T> getById(int id);
    void save(T t);
    void delete(int[] ids);
}
