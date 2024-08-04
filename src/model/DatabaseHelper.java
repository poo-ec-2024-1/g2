package model;

import java.sql.SQLException;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import model.Aviao;
import model.Voo;

public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:sqlite:avioes.db";
    private ConnectionSource connectionSource;

    public DatabaseHelper() {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
            TableUtils.createTableIfNotExists(connectionSource, Aviao.class);
            TableUtils.createTableIfNotExists(connectionSource, Voo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public void close() throws Exception {
        try {
            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

