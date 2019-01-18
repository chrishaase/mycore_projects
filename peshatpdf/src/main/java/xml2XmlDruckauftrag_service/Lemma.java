package main.java.xml2XmlDruckauftrag_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="lemma")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lemma {

    private String mycoreid;
    private String vocalizedSpelling;
    private String root;
    private String wordClass;
    private String gender;
    private String verbStem;

    @XmlElement(name="definition")
    private List<Definition> listDefinitions = null;

    @XmlElement(name="source")
    private List<Source> listSources = null;


    public String getVocalizedSpelling() {
        return vocalizedSpelling;
    }

    public void setVocalizedSpelling(String vocalizedSpelling) {
        this.vocalizedSpelling = vocalizedSpelling;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVerbStem() {
        return verbStem;
    }

    public void setVerbStem(String verbStem) {
        this.verbStem = verbStem;
    }

    public List<Definition> getListDefinitions() {
        return listDefinitions;
    }

    public void setListDefinitions(List<Definition> listDefinitions) {
        this.listDefinitions = listDefinitions;
    }

    public List<Source> getListSources() {
        return listSources;
    }

    public void setListSources(List<Source> listSources) {
        this.listSources = listSources;
    }

    public String getMycoreid() {
        return mycoreid;
    }

    public void setMycoreid(String mycoreid) {
        this.mycoreid = mycoreid;
    }
}
