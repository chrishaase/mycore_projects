<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xlink="http://www.w3.org/1999/xlink">
    <xsl:output method="xml" version="1.0" indent="yes"/>
    <xsl:template match="/">
        <root>

            <xsl:for-each select="/mycoreobject/metadata/box.definition_id/definition_id/@xlink:href">
                <link>
                <xsl:value-of select="."/>
                </link>
            </xsl:for-each>

        </root>
    </xsl:template>
</xsl:stylesheet >