<?xml version="1.0" encoding="ISO-8859-1"?> <xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xlink="http://www.w3.org/1999/xlink"> 
<xsl:output method="text" omit-xml-declaration="yes" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
<xsl:text>\documentclass[12pt]{article}
    \usepackage{polyglossia}
    \setmainlanguage{english}
    \setotherlanguage{hebrew}
    \usepackage{fontspec}
    \setmainfont{Frank Ruehl CLM}
    \usepackage{setspace}
    \singlespacing
    \pagestyle{plain}
    \begin{document}
    \raggedleft
</xsl:text>
    <xsl:text>Vocalized Spelling:
        \\
    \bigskip</xsl:text>
    <xsl:text>&#xa;</xsl:text>
    <xsl:for-each select="mycoreobject/metadata/box.vocalized_spelling/vocalized_spelling">
        <xsl:if test="@xml:lang='he'">
           <xsl:text>\begin{hebrew}</xsl:text>
            <xsl:text>&#xa;</xsl:text>
            <xsl:text>\raggedleft</xsl:text>
            <xsl:text>&#xa;</xsl:text>
            <xsl:value-of select = "." />
            <xsl:text>&#xa;</xsl:text>
             <xsl:text>\end{hebrew}\\</xsl:text>
            <xsl:text>&#xa;</xsl:text>
        </xsl:if>
        <xsl:if test="@xml:lang='en'">
            <xsl:text>\raggedleft
            </xsl:text>
            <xsl:value-of select = "." />
            <xsl:text>&#xa;</xsl:text>
            <xsl:text>\\</xsl:text>
            <xsl:text>&#xa;</xsl:text>
            </xsl:if>
    </xsl:for-each>


    <xsl:text>Lemma: Grammatical Information
        \\
    \bigskip</xsl:text>
    <xsl:text>&#xa;</xsl:text>

<xsl:for-each select="mycoreobject/metadata/box.year/year">
    <xsl:if test="@xml:lang='he'">
        <xsl:text>\begin{hebrew}</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\raggedleft</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\end{hebrew}\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
    <xsl:if test="@xml:lang='en'">
            <xsl:text>\raggedleft
            </xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.title/title">
    <xsl:if test="@xml:lang='he'">
        <xsl:text>\begin{hebrew}</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\raggedleft</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\end{hebrew}\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
    <xsl:if test="@xml:lang='en'">
            <xsl:text>\raggedleft
            </xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.place/place">
    <xsl:if test="@xml:lang='he'">
        <xsl:text>\begin{hebrew}</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\raggedleft</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\end{hebrew}\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
    <xsl:if test="@xml:lang='en'">
            <xsl:text>\raggedleft
            </xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
</xsl:for-each>
<xsl:for-each select="mycoreobject/metadata/box.publisher/publisher">
    <xsl:if test="@xml:lang='he'">
        <xsl:text>\begin{hebrew}</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\raggedleft</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\end{hebrew}\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
    <xsl:if test="@xml:lang='en'">
            <xsl:text>\raggedleft
            </xsl:text>
        <xsl:value-of select = "." />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>\\</xsl:text>
        <xsl:text>&#xa;</xsl:text>
    </xsl:if>
</xsl:for-each>
    <xsl:text>
        \bigskip
        \raggedleft
         </xsl:text>
<xsl:text>ModifyDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='modifydate']" />
<xsl:text>&#xa;</xsl:text>
    <xsl:text>\\</xsl:text>
    <xsl:text>&#xa;</xsl:text>
<xsl:text>CreateDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='createdate']" />
<xsl:text>&#xa;</xsl:text>
    <xsl:text>\end{document}</xsl:text>
 </xsl:template> 
</xsl:stylesheet>
