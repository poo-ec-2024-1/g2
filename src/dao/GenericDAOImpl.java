package dao;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import dao.GenericDAO;


public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {
    protected Dao<T, ID> dao;

    public GenericDAOImpl(ConnectionSource connectionSource, Class<T> clazz) throws SQLException {
        dao = DaoManager.createDao(connectionSource, clazz);
    }

    @Override
    public void create(T entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public T read(ID id) throws SQLException {
        return dao.queryForId(id);
    }

    @Override
    public List<T> readAll() throws SQLException {
        return dao.queryForAll();
    }

    @Override
    public void update(T entity) throws SQLException {
        dao.update(entity);
    }

    @Override
    public void delete(T entity) throws SQLException {
        dao.delete(entity);
    }
}

