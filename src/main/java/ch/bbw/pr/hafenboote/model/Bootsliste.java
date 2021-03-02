package ch.bbw.pr.hafenboote.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @class: Bootsliste
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/
public class Bootsliste {

    private ObservableList <Boot> boote;

    public Bootsliste() {
        super();
        boote = FXCollections.<Boot>observableArrayList();
    }

    public void add(Boot boot){
        this.boote.add(boot);
    }

    public ObservableList<Boot> getBoote(){
        return boote;
    }

    @Override
    public String toString() {
        return "Bootsliste{" +
                "boote=" + boote +
                '}';
    }
}
