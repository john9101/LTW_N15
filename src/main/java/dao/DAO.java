package dao;

import database.JDBIConnector;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public interface DAO<T> {
    //READ
    List<T> selectALl();

    T selectById(int id);

    //CREATE
    int insert(T o);

    int insertAll(List<T> list);

    //DELETE
    int delete(T o);

    int deleteAll(List<T> list);

    //UPDATE
    int update(Object o);

}
