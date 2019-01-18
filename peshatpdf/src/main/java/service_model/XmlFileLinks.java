package main.java.service_model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="xmlFileLinks")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFileLinks {

    @XmlElement(name="xmlFileLink")
    private List<XmlFileLink> xmlFileLinks = null;


    public List<XmlFileLink> getFileLinks(){
        return xmlFileLinks;
    }

    public void setFileLinks(List<XmlFileLink> xmlFileLinks){
        this.xmlFileLinks= xmlFileLinks;
    }


}

