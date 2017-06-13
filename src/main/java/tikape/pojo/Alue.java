//luokka alueelle
package tikape.pojo;

import java.sql.Date;

public class Alue {
    
    private String nimi;
    private String luomispaiva;  //täysin varma en ole onko tämä oikein toimiva
    private String viimeisinViestiDate;
    
    public Alue(String nimi, String paiva) {
        //päivämäärien initalisointi ? tässä vai antaako kutsuessa päivämäärän kuten nyt
        this.luomispaiva=paiva;
        this.nimi= nimi;
    }
    
    //setterit ja getterit
    
    public void setViimeisinViesti(String paivamaara) {
        this.viimeisinViestiDate=paivamaara;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String getViimeisinViesti() {
        return this.viimeisinViestiDate;
    }
    
    public String getLuomispaiva() {
        return this.luomispaiva;
    }

    @Override
    public String toString() {
        return nimi + this.luomispaiva + this.viimeisinViestiDate;
    }
    
}
