package main.java.mcrData2xmlDruckvorlage;

/**
 * Vereinfachte Entity für MCR-Objekte die der Erstellung einer xml-Druckvorlage dienen aus einer Abfrage
 */


public abstract class MCRAbstractObject {

    private String mycoreid;

    MCRAbstractObject(){

    }

    public String getMycoreid() {
        return mycoreid;
    }

    public void setMycoreid(String mycoreid) {
        this.mycoreid = mycoreid;
    }
}
