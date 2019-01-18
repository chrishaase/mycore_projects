package main.java.data2Druckvorlage_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xmlFileLink")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFileLink {

    private String link;

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
