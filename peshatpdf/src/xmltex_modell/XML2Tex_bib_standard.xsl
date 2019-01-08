<?xml version="1.0" encoding="ISO-8859-1"?> <xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xlink="http://www.w3.org/1999/xlink"> 
<!-- xml bibliography to tex with babel hack hebrew 
    author chase -->
    <xsl:output method="text" omit-xml-declaration="yes" encoding="UTF-8" indent="yes"/> 
<xsl:template match="/">
<xsl:text>\documentclass{article}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>% babel hack to get hebrew working
\makeatletter
\let\l@hebrew\l@nohyphenation
\makeatother</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>% utf8x requires ucs
\usepackage{ucs}
\usepackage[utf8x]{inputenc}
\usepackage[english,hebrew]{babel}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\usepackage{pslatex}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\usepackage{cjhebrew}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\begin{document}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:for-each select="mycoreobject/metadata/box.author/author"> 
<xsl:text>\begin{otherlanguage}{english}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>Author - Year - Title - Place - Publisher </xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\end{otherlanguage}</xsl:text>
<xsl:text>&#xa;</xsl:text>
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
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\begin{otherlanguage}{english}</xsl:text>
<xsl:text>&#xa;</xsl:text>
</xsl:for-each>
<xsl:text>ModifyDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='modifydate']" />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>CreateDate: </xsl:text>
<xsl:value-of select = "//servdate[@type='createdate']" />
<xsl:text>&#xa;</xsl:text>
<xsl:text>\newline</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\end{otherlanguage}</xsl:text>
<xsl:text>&#xa;</xsl:text>
<xsl:text>\end{document}</xsl:text>
 </xsl:template> 
</xsl:stylesheet>
