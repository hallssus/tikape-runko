//aihe-olio
package tikape.pojo;

import java.sql.Date;

public class Aihe {
    private Integer id;
    private String nimi;
    private String luomispaiva;
    private String uusinViesti;
    private String alue;     //tästä en ole yhtään varma miten viittausten toisiin kanssa toimitaan tässä tapauksessa
    
    public Aihe(Integer id, String nimi, String luomispaiva, String alue) {
        this.id=id;
        this.nimi=nimi;
        this.luomispaiva=luomispaiva;
        this.alue=alue;
    }
    
    //setterit ja getterit
    
    public void setUusinViesti(String pm) {
        this.uusinViesti=pm;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String getAlue() {
        return this.alue;
    }
    
    public String getViimeisinViesti() {
        return this.uusinViesti;
    }
    
    public String getLuomispaivamaara() {
        return this.luomispaiva;
    }
}