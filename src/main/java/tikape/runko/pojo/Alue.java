//luokka alueelle
package tikape.runko.pojo;

import java.sql.Date;
import java.util.List;

public class Alue {
    
    private String nimi;
    private Date luomispaiva;  //täysin varma en ole onko tämä oikein toimiva
    private Date viimeisinViestiDate;
    private List<Aihe> aiheet;   //kalvoissa oli näin tehty. siitä mallia. oletettavasti helpottaa ksäittelyä.
    
    public Alue(String nimi, Date paiva) {
        //päivämäärien initalisointi ? tässä vai antaako kutsuessa päivämäärän kuten nyt
        this.luomispaiva=paiva;
        this.nimi= nimi;
    }
    
    public void addAihe(Aihe a) {
        this.aiheet.add(a);
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
