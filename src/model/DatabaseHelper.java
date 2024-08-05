package model;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;
import dao.AviaoDAO;
import dao.VooDAO;
import dao.PassageiroDAO;

public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:h2:./data/db";
    private ConnectionSource connectionSource;

    public DatabaseHelper() throws SQLException {
        connectionSource = new JdbcConnectionSource(DATABASE_URL);
        setupDatabase();
    }

    private void setupDatabase() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Aviao.class);
        TableUtils.createTableIfNotExists(connectionSource, Voo.class);
        TableUtils.createTableIfNotExists(connectionSource, Passageiro.class);
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public AviaoDAO getAviaoDao() throws SQLException {
        return new AviaoDAO(connectionSource);
    }

    public VooDAO getVooDao() throws SQLException {
        return new VooDAO(connectionSource);
    }

    public PassageiroDAO getPassageiroDao() throws SQLException {
        return new PassageiroDAO(connectionSource);
    }

    public void close() throws Exception {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
