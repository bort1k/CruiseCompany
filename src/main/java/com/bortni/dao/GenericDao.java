package com.bortni.dao;

import com.bortni.exceptions.ReadException;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T create();

    T getByPK(int key) throws ReadException;

    void update(T object) throws ReadException;

    void delete(T object) throws ReadException;

    List<T> getAll() throws ReadException;

    void close();
}
