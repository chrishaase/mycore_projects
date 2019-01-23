package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name="lemma")
@XmlAccessorType(XmlAccessType.FIELD)
public class MCRLemma extends MCRAbstractObject {


    private String vocalizedSpelling;
    private String root;
    private String wordClass;
    private String gender;
    private String verbStem;


    @XmlElement(name="definition")
    private Set<MCRDefinition> listMCRDefinitions = null;

    @XmlElement(name="bibliographicalSource")
    private Set<MCRBibliographicalSource> listMCRBibliographicalSources = null;


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

    public Set<MCRDefinition> getListMCRDefinitions() {
        return listMCRDefinitions;
    }

    public void setListMCRDefinitions(Set<MCRDefinition> listMCRDefinitions) {
        this.listMCRDefinitions = listMCRDefinitions;
    }

    public Set<MCRBibliographicalSource> getListMCRBibliographicalSources() {
        return listMCRBibliographicalSources;
    }

    public void setListMCRBibliographicalSources(Set<MCRBibliographicalSource> listMCRBibliographicalSources) {
        this.listMCRBibliographicalSources = listMCRBibliographicalSources;
    }


}
