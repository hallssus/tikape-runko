
package tikape.database;

import java.sql.SQLException;
import java.util.List;
import tikape.collectors.AiheCollector;
import tikape.pojo.Aihe;



public class AiheDao implements Dao<Aihe, Integer>{
    
    private Database database;

    public AiheDao(Database database) {
        this.database = database;
    }

    @Override
    public Aihe findOne(Integer key) throws SQLException {
        List<Aihe> aiheet = this.database.queryAndCollect("SELECT * FROM Aihe WHERE id = ?", new AiheCollector(), key);
        if (aiheet.isEmpty()) {
            return null;
        }

        return aiheet.get(0);
    }
    
    public List<Aihe> etsiKaikkiAlueenNimella(String alue) throws SQLException {
        List<Aihe> aiheet = this.database.queryAndCollect("SELECT * FROM Aihe WHERE alue = ?", new AiheCollector(), alue);
        if (aiheet.isEmpty()){
            return null;
        }
        return aiheet;
    }

    @Override
    public void save(Aihe aihe) throws SQLException {
        this.database.update("INSERT INTO Aihe (nimi, luomispaiva, alue) VALUES (?, ?, ?)", aihe.getNimi(), aihe.getLuomispaivamaara(), aihe.getAlue());
    }
    
    public void lisaaAihe(String nimi, String luomispaiva, String alue) throws SQLException {
        this.database.update("INSERT INTO Aihe (nimi, luomispaiva, alue) VALUES (?, ?, ?)", nimi, luomispaiva, alue);
    }

    @Override
    public List<Aihe> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Aihe", new AiheCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        this.database.update("DELETE FROM Aihe WHERE id = ?", key);
    }
    
    public Integer palautaIdNimenMukaan(String nimi) throws SQLException {
            List<Aihe> aiheet = this.database.queryAndCollect("SELECT * FROM Aihe WHERE nimi = ?", new AiheCollector(), nimi);
        if (aiheet.isEmpty()) {
            return null;
        }

        return aiheet.get(0).getId();
    }
    
   

    
}
