package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dao.AviaoDAO;
import dao.PassageiroDAO;
import dao.VooDAO;

import java.sql.SQLException;

public class DatabaseHelper {
    private final ConnectionSource connectionSource;
    private final AviaoDAO aviaoDAO;
    private final VooDAO vooDAO;
    private final PassageiroDAO passageiroDAO;

    public DatabaseHelper() throws SQLException {
        connectionSource = new JdbcConnectionSource("jdbc:sqlite:yourdatabase.db");
        aviaoDAO = new AviaoDAO(connectionSource);
        vooDAO = new VooDAO(connectionSource);
        passageiroDAO = new PassageiroDAO(connectionSource);
        
        TableUtils.createTableIfNotExists(connectionSource, Aviao.class);
        TableUtils.createTableIfNotExists(connectionSource, Voo.class);
        TableUtils.createTableIfNotExists(connectionSource, Passageiro.class);
        
    }

    public AviaoDAO getAviaoDao() {
        return aviaoDAO;
    }

    public VooDAO getVooDao() {
        return vooDAO;
    }

    public PassageiroDAO getPassageiroDao() {
        return passageiroDAO;
    }

    public void close() throws Exception, SQLException {
        connectionSource.close();
    }
}

