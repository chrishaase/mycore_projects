package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name="quotationText_he")
@XmlAccessorType(XmlAccessType.FIELD)

public class MCRQuotation extends MCRAbstractObject{



    private String quotationText_he;
    private String pages;

    @XmlElement(name="bibliographicalSource")
    private Set<MCRBibliographicalSource> MCRBibliographicalSources = null;

    public String getQuotationText_he() {
        return quotationText_he;
    }

    public void setQuotationText_he(String quotationText_he) {
        this.quotationText_he = quotationText_he;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Set<MCRBibliographicalSource> getMCRBibliographicalSources() {
        return MCRBibliographicalSources;
    }

    public void setMCRBibliographicalSources(Set<MCRBibliographicalSource> MCRBibliographicalSources) {
        this.MCRBibliographicalSources = MCRBibliographicalSources;
    }


}
