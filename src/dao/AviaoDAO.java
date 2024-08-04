package dao;

import java.sql.SQLException;
import com.j256.ormlite.support.ConnectionSource;
import model.Aviao;
import dao.GenericDAOImpl;

public class AviaoDAO extends GenericDAOImpl<Aviao, Integer> {
    public AviaoDAO(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Aviao.class);
    }
}

