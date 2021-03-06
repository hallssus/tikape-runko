
package tikape.runko.database;

import tikape.runko.database.Dao;
import tikape.runko.database.Database;
import java.sql.SQLException;
import java.util.List;
import tikape.runko.collectors.ViestiCollector;
import tikape.runko.pojo.Viesti;

public class ViestiDao implements Dao<Viesti, Integer>{
    
    private Database database;

    public ViestiDao(Database database) {
        this.database = database;
    }

    @Override
    public Viesti findOne(Integer key) throws SQLException {
        List<Viesti> viestit = this.database.queryAndCollect("SELECT * FROM Viesti WHERE id = ?", new ViestiCollector(), key);
        if (viestit.isEmpty()) {
            return null;
        }

        return viestit.get(0);
    }

    @Override
    public void save(Viesti viesti) throws SQLException {
        this.database.update("INSERT INTO Viesti (lahettaja, sisalto, aihe, alue) VALUES (?, ?, ?, ?)", viesti.getLahettaja(), viesti.getSisalto(), viesti.getAihe(), viesti.getAlue());
    }

    @Override
    public List<Viesti> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Viesti", new ViestiCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        this.database.update("DELETE FROM Viesti WHERE id = ?", key);
    }
    
}
