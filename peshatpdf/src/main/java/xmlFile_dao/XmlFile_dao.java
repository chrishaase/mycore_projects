package main.java.xmlFile_dao;

import main.java.controller.AppData;
import main.java.util.ClassLoaderUtil;
import main.java.util.FileHandler;
import main.java.controller.RequestData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class XmlFile_dao {

    private final XmlGetRest rest;
    private final FileHandler fileHandler;
    private final AppData appData;

    public XmlFile_dao(XmlGetRest rest, FileHandler fileHandler, AppData appData){

        this.fileHandler = fileHandler;
        this.rest = rest;
        this.appData = appData;

    }

    public Boolean getXmlFileInPath(RequestData requestData){

        //. check if xml in xml-filestore
        Boolean b = fileHandler.fileExists(requestData.getXmlFile());

        // if not present, load from rest service and saveXmlStr2File to filepath
        if (!b){
          b = rest.httpGetAndSave2File(requestData);
        }

        // final evaluation ob file jetzt in filestore
        b = fileHandler.fileExists(requestData.getXmlFile());

        return b;
    }


    // TODO Methode ALL_BASE_FILES: BASE-FILES DOWNLOADEN - Datamodels, Peshatclasses

    // TODO Methode: LinkedFiles FINALIZE PLUS TEST

    public void getLinkedFilesinPath(RequestData requestData){

        //1. CallTransformerFactory xml2xmlLinkFile

        this.transformXml2XmlLinkFile(requestData);

        //2. Unmarshal to Object-Array
        try {

            File file = requestData.getXmlLinksFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlFileLinks.class);


            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XmlFileLinks xmlFileLinks = (XmlFileLinks) jaxbUnmarshaller.unmarshal(file);

            for(XmlFileLink link: xmlFileLinks.getFilelinks()){
                System.out.println(link.getLink());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }

    private void transformXml2XmlLinkFile(RequestData requestData){

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(appData.getResourcePath() + "xml2xml_linkExtract.xsl", this.getClass());

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getXmlLinksFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // TODO ALTERNATIV: GET FROM FILEPATH - PATH RESOLVER
    // Construct path from link
    // 1. substring minus peshat_ at front
    // 2. substring minus _12345678 am Ende
    // 3 Substring DataType / 1234 / 56 / mycoreID.xml
    // 4.Substring Folder= 1234 / 56 /
    // 5.xml-path home/ahzch/shutmnt/data/metadata/peshat/datatype/[datatype]/1234/56/mycoreID.xml




    @XmlRootElement(name="filelink")
    @XmlAccessorType(XmlAccessType.FIELD)
    class XmlFileLink {

        private String link;

        public void setLink(String link) {
            this.link = link;
        }

        public String getLink() {
            return link;
        }
    }

    @XmlRootElement(name="filelinks")
    class XmlFileLinks {

        @XmlElement(name="filelink")
        private List<XmlFileLink> filelinks = null;

        public List<XmlFileLink> getFilelinks(){
            return filelinks;
        }

        public void setFilelinks(List<XmlFileLink> xmlFileLinks){
            this.filelinks= filelinks;
        }

    }

}
