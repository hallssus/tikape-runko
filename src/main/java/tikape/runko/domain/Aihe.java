//aihe-olio
package tikape.runko.domain;

import java.sql.Date;

public class Aihe {
    private Integer id;
    private String nimi;
    private Date luomispaiva;
    private Date uusinViesti;
    private String alue;     //tästä en ole yhtään varma miten viittausten toisiin kanssa toimitaan tässä tapauksessa
    
    public Aihe(Integer id, String nimi, Date luomispaiva, String alue) {
        this.id=id;
        this.nimi=nimi;
        this.luomispaiva=luomispaiva;
        this.alue=alue;
    }
    
    //setterit ja getterit
    
    public void setUusinViesti(Date pm) {
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
    
    public Date getViimeisinViesti() {
        return this.uusinViesti;
    }
    
    public Date getLuomispaivamaara() {
        return this.luomispaiva;
    }
}