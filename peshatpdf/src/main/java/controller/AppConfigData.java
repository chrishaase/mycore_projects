package main.java.controller;

import main.java.util.ClassLoaderUtil;

import java.net.URL;

public class AppConfigData {


    // APP DATA
    private final String outFilePath = "/mycore";
    private final String urlPath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
    private final String resourcePath ="main/resources/";


    // data to xml Druckvorlage - fo
    private final String xsltDruckvorlageXml2Fo = "druckvorlageXml2Fo.xsl";

    // mcr single xml - to pdf
    private final String pdfTexCommand = "xelatex";
    private final String xsltFileNameTex = "mcrXml2Tex_lemma_xelatex.xsl";
    private final String xsltFileNameFop = "mcrXml2Fo_lemma.xsl";

    // APP constructed - actual path to fopConfigFile
    private final String fopConfigFileName ="fop.xconf";
    private final String fopConfigResource;

    AppConfigData(){


        // get real path for fop-config
        //actual path to fop-config file
        String resourceFilewithPath = resourcePath+fopConfigFileName;
        String string = "";
        try {
            URL url = ClassLoaderUtil.getResource(resourceFilewithPath, this.getClass());
            string = url.toURI().toString();

        } catch (Exception e){
            e.printStackTrace();
        }
        fopConfigResource = string.substring(5); // cut-off first five characters = "file:"
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public String getUrlPath() {
        return urlPath;
    }

   public String getResourcePath() {
        return resourcePath;
    }

    public String getPdfTexCommand() {
        return pdfTexCommand;
    }

    public String getXsltFileNameTex() {
        return xsltFileNameTex;
    }

    public String getXsltFileNameFop() {
        return xsltFileNameFop;
    }

    public String getFopConfigResource() {
        return fopConfigResource;
    }

    public String getXsltDruckvorlageXml2Fo() {
        return xsltDruckvorlageXml2Fo;
    }
}
