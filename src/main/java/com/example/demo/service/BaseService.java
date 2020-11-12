package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    int save(T t);
    int delete(int[] ids);
}
