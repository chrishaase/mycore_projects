package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name="definition")
@XmlAccessorType(XmlAccessType.FIELD)

public class MCRDefinition extends MCRAbstractObject{


    private String definition_en;

    @XmlElement(name="quotation")
    private Set<MCRQuotation> MCRQuotations = null;



    public Set<MCRQuotation> getMCRQuotations() {
        return MCRQuotations;
    }

    public void setMCRQuotations(Set<MCRQuotation> MCRQuotations) {
        this.MCRQuotations = MCRQuotations;
    }



    public String getDefinition_en() {
        return definition_en;
    }

    public void setDefinition_en(String definition_en) {
        this.definition_en = definition_en;
    }
}
