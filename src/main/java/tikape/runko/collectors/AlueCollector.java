
package tikape.runko.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;
import tikape.runko.database.Collector;
import tikape.runko.pojo.Alue;

public class AlueCollector implements Collector<Alue>{

    @Override
    public Alue collect(ResultSet rs) throws SQLException {
return new Alue(rs.getString("nimi"), rs.getDate("luomispaiva"));    }
    
}
