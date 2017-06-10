//luokka alueelle
package tikape.runko.domain;

import java.sql.Date;

public class Alue {
    
    private String nimi;
    private Date luomispaiva;  //täysin varma en ole onko tämä oikein toimiva
    private Date viimeisinViestiDate;
    
    public Alue(String nimi, Date paiva) {
        //päivämäärien initalisointi ? tässä vai antaako kutsuessa päivämäärän kuten nyt
        this.luomispaiva=paiva;
        this.nimi= nimi;
    }
    
    //setterit ja getterit
    
    public void setViimeisinViesti(Date paivamaara) {
        this.viimeisinViestiDate=paivamaara;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public Date getViimeisinViesti() {
        return this.viimeisinViestiDate;
    }
    
    public Date getLuomispaiva() {
        return this.luomispaiva;
    }
}
