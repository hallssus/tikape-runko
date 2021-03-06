
package tikape.runko.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;
import tikape.runko.database.Collector;
import tikape.runko.pojo.Aihe;


public class AiheCollector implements Collector<Aihe>{

    @Override
    public Aihe collect(ResultSet rs) throws SQLException {
        return new Aihe(rs.getInt("id"), rs.getString("nimi"), rs.getDate("luomispaiva"), rs.getString("aihe"));
    }
    
}
