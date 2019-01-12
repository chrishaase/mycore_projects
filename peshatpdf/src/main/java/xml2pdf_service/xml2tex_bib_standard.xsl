<?xml version="1.0" encoding="ISO-8859-1"?> <xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xlink="http://www.w3.org/1999/xlink"> 
<xsl:output method="text" omit-xml-declaration="yes" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
<xsl:text>\documentclass{article}
\usepackage{ucs}
    \usepackage[utf8x]{inputenc}
    \usepackage[hebrew, english]{babel}
    \begin{document}
    \begin{flushright}
</xsl:text>
    <xsl:text>Author - Year - Title - Place - Publisher
        \par
        \end{flushright}
        \begin{otherlanguage*}{hebrew}
        \newline</xsl:text>
    <xsl:text>&#xa;</xsl:text>
<xsl:for-each select="mycoreobject/metadata/box.author/author">
<xsl:value-of select = "." />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.year/year">
    <xsl:value-of select = "." />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.title/title"> 
<xsl:value-of select = "." />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.place/place"> 
<xsl:value-of select = "." />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.publisher/publisher"> 
<xsl:value-of select = "." />
<xsl:text>&#xa;</xsl:text>
    <xsl:text>\par
        \end{otherlanguage*}
        \begin{flushright}</xsl:text>
    <xsl:text>&#xa;</xsl:text>
    <xsl:text>\newline
        \null
        \hfill </xsl:text>
    <xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:text>ModifyDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='modifydate']" />
<xsl:text>&#xa;</xsl:text>
    <xsl:text>\newline
        \null
        \hfill </xsl:text>
    <xsl:text>&#xa;</xsl:text>
<xsl:text>CreateDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='createdate']" />
<xsl:text>&#xa;</xsl:text>
    <xsl:text>\end{flushright}
        \end{document}</xsl:text>
 </xsl:template> 
</xsl:stylesheet>
