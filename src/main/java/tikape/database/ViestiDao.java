
package tikape.database;

import tikape.database.Dao;
import tikape.database.Database;
import java.sql.SQLException;
import java.util.List;
import tikape.collectors.ViestiCollector;
import tikape.pojo.Viesti;

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
    
    public List<Viesti> kaikkiAiheenViestit(String aihe) throws SQLException {
        AiheDao aiheDao=new AiheDao(this.database);
        Integer aihe0=aiheDao.palautaIdNimenMukaan(aihe);
        List<Viesti> viestit= this.database.queryAndCollect("SELECT * FROM Viesti WHERE aihe = ?", new ViestiCollector(), aihe0);
        if (viestit.isEmpty()) {
            return null;
        }
        return viestit;
    }
    
    public List<Viesti> aiheenViestit(Integer id) throws SQLException {
        AiheDao ad= new AiheDao(this.database);
        List<Viesti> viestit= this.database.queryAndCollect("SELECT * FROM Viesti WHERE aihe = ?", new ViestiCollector(), id);
        if (viestit.isEmpty()) {
            return null;
        }
        return viestit;
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
