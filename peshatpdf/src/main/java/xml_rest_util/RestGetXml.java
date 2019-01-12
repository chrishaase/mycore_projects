package main.java.xml_rest_util;

public interface RestGetXml {

    String httpGet (String urlpath, String id);


    void httpGetAndSave2File(String urlpath, String id, String filepath);
}