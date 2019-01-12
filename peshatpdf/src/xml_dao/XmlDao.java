package xml_dao;

import xml_rest_util.RestGetXml;

public interface XmlDao {

    Boolean getXmlFileInPath();

    void setRest(RestGetXml rest);


}
