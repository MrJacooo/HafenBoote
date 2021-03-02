package ch.bbw.pr.hafenboote.model;

/**
 * @class: Segelboot
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/

public class Segelboot extends Boot{
    public int segelflaeche;
    public Segelboot( String name,int laenge, int segelflaeche) {
        super(name,laenge );
        this.segelflaeche = segelflaeche;
    }

    @Override
    public String toString() {
        return "Segelboot{" +
                "segelflaeche=" + segelflaeche +
                "} " + super.toString();
    }
} //End of Class
