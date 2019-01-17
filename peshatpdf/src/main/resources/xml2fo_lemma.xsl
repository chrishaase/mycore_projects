<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" indent="yes"/>
    <xsl:template match="/">
        <fo:root font-size="12pt" font-family="Frank Ruehl CLM" xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master page-height="297mm" page-width="210mm"
                                       margin="5mm 25mm 5mm 25mm" master-name="PageMaster">
                    <fo:region-body margin="20mm 0mm 20mm 0mm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="PageMaster">
                <fo:flow flow-name="xsl-region-body" line-height="1.7" font-family="Frank Ruehl CLM">
                    <fo:block text-align="right" xml:lang="en" font-size="12pt">
                        <xsl:text>Philosophic and Scientific Hebrew Terminology in Context (PESHAT)–
A Thesaurus of Medieval Hebrew Philosophical Terminology</xsl:text>
                        <xsl:text>&#xa;</xsl:text>
                        <xsl:text>&#x2028;</xsl:text>
                    </fo:block>
                    <fo:table>
                        <fo:table-column column-width="20pt"/>
                        <fo:table-column column-width="20pt"/>
                    <fo:table-body>
                    <fo:table-row>
                    <fo:table-cell>
                        <fo:block>
                            <xsl:text>Test1</xsl:text>
                        </fo:block>
                    </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:text>Test2</xsl:text>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    </fo:table-body>
                    </fo:table>
                <xsl:for-each select="mycoreobject/metadata/box.vocalized_spelling/author">
                    <xsl:if test="@xml:lang='he'">
                        <fo:block text-align="right" xml:lang="he" font-size="12pt">
                            <xsl:value-of select = "." />
                            <xsl:text>&#xa;</xsl:text>
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="@xml:lang='en'">
                        <fo:block text-align="right" xml:lang="en" font-size="12pt">
                            <xsl:value-of select = "." />
                            <xsl:text>&#xa;</xsl:text>
                        </fo:block>
                    </xsl:if>
                </xsl:for-each>
                    <xsl:for-each select="mycoreobject/metadata/box.year/year">
                        <xsl:if test="@xml:lang='he'">
                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                        <xsl:if test="@xml:lang='en'">
                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                    </xsl:for-each>
                    <xsl:for-each select="mycoreobject/metadata/box.title/title">
                        <xsl:if test="@xml:lang='he'">
                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                        <xsl:if test="@xml:lang='en'">
                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                    </xsl:for-each>
                    <xsl:for-each select="mycoreobject/metadata/box.place/place">
                        <xsl:if test="@xml:lang='he'">
                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                        <xsl:if test="@xml:lang='en'">
                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                    </xsl:for-each>
                    <xsl:for-each select="mycoreobject/metadata/box.publisher/publisher">
                        <xsl:if test="@xml:lang='he'">
                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                            </fo:block>
                        </xsl:if>
                        <xsl:if test="@xml:lang='en'">
                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                <xsl:value-of select = "." />
                                <xsl:text>&#xa;</xsl:text>
                                <xsl:text>&#x2028;</xsl:text>
                            </fo:block>
                        </xsl:if>
                    </xsl:for-each>
                    <fo:block text-align="right" xml:lang="en" font-size="12pt">
                    <xsl:text>ModifyDate: </xsl:text>
                    <xsl:value-of select = "//servdate[@type='modifydate']" />
                    </fo:block>
                    <fo:block text-align="right" xml:lang="en" font-size="12pt">
                        <xsl:text>CreateDate: </xsl:text>
                    <xsl:value-of select = "//servdate[@type='createdate']" />
                     </fo:block>


                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet >