<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xlink="http://www.w3.org/1999/xlink">
    <xsl:output method="xml" version="1.0" indent="yes"/>
    <xsl:template match="/">
        <xmlFileLinks>

            <xsl:for-each select="/mycoreobject/metadata/box.bibliography_source_id/bibliography_source_id/@xlink:href">
            <xmlFileLink>
                <type>bibliography_source_id</type>
                <link>
                    <xsl:value-of select="."/>
                </link>
            </xmlFileLink>
        </xsl:for-each>


        </xmlFileLinks>
    </xsl:template>
</xsl:stylesheet >