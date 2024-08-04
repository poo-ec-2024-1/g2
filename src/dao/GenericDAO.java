package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {
    void create(T entity) throws SQLException;
    T read(ID id) throws SQLException;
    List<T> readAll() throws SQLException;
    void update(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
}

