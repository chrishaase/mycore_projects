package main.java.data2xmlDruckvorlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="definition")
@XmlAccessorType(XmlAccessType.FIELD)

public class Definition extends MCRAbstractObject{


    private String definition_en;

    @XmlElement(name="quotation")
    private List<Quotation> quotations = null;



    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }



    public String getDefinition_en() {
        return definition_en;
    }

    public void setDefinition_en(String definition_en) {
        this.definition_en = definition_en;
    }
}
