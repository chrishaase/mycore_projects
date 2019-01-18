package main.java.data2Druckvorlage_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="quotation")
@XmlAccessorType(XmlAccessType.FIELD)

public class Quotation {

    private String mycoreid;

    private String quotation;
    private String pages;

    @XmlElement(name="source")
    private List<Source> sources = null;

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getMycoreid() {
        return mycoreid;
    }

    public void setMycoreid(String mycoreid) {
        this.mycoreid = mycoreid;
    }
}
