
package tikape.runko.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;
import tikape.runko.database.Collector;
import tikape.runko.pojo.Viesti;

public class ViestiCollector implements Collector<Viesti>{

    @Override
    public Viesti collect(ResultSet rs) throws SQLException {
        return new Viesti(rs.getInt("id"), rs.getString("lahettaja"), rs.getString("sisalto"), rs.getInt("aihe"), rs.getString("alue"));
    }
    
}
