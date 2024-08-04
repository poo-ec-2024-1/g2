package dao;

import java.sql.SQLException;
import com.j256.ormlite.support.ConnectionSource;
import model.Voo;
import dao.GenericDAOImpl;

public class VooDAO extends GenericDAOImpl<Voo, Integer> {
    public VooDAO(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Voo.class);
    }
}
