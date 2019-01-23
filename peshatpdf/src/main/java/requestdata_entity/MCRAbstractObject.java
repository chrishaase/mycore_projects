package main.java.requestdata_entity;

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
