<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" indent="yes"/>
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master page-height="297mm" page-width="210mm"
                                       margin="5mm 25mm 5mm 25mm" master-name="PageMaster">
                    <fo:region-body margin="20mm 0mm 20mm 0mm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="PageMaster">
                <fo:flow flow-name="xsl-region-body" line-height="1.7" font-family="Cardo">

        <xsl:for-each select="mycoreobject/metadata/box.author/author">
            <fo:block text-align="right" xml:lang="he">
                english
                <xsl:value-of select = "." />
                <xsl:text>&#xa;</xsl:text>
                </fo:block>
                </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet >