package ch.bbw.pr.hafenboote.model;

/**
 * @class: Motorboot
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/

public class Motorboot extends  Boot {
    public double leistung;

    public Motorboot(String name, int laenge, double leistung) {
        super(name, laenge);
        this.leistung = leistung;
    }

    @Override
    public String toString() {
        return "Motorboot{" +
                "leistung=" + leistung +
                "} " + super.toString();
    }
} //End of Class
