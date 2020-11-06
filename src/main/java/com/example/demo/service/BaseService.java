package com.example.demo.service;

public interface BaseService<T> {
    void save(T t);
    void delete(int[] ids);
}
