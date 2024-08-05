package dao;


import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import model.Passageiro;

public class PassageiroDAO extends GenericDAOImpl<Passageiro, Integer> {
    public PassageiroDAO(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Passageiro.class);
    }
}

