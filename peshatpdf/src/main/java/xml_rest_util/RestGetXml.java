package main.java.xml_rest_util;

public interface RestGetXml {

    String httpGet ();
    Boolean save(String xmlobject);
    Boolean httpGetAndSave2File();
}