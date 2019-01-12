package xml_rest_util;

import controller.RequestData;

public interface RestGetXml {

    String httpGet (String urlpath, String id);


    void httpGetAndSave2File(String urlpath, String id, String filepath);
}