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
                          <fo:block text-align="center" xml:lang="en" font-size="12pt" font-style="italic">
                        <xsl:text>Philosophic and Scientific Hebrew Terminology in Context (PESHAT)–
A Thesaurus of Medieval Hebrew Philosophical Terminology</xsl:text>
                         <xsl:text>&#x2028;</xsl:text>
                              <xsl:text>&#x2028;</xsl:text>

                    </fo:block>
                    <fo:block text-align="center" xml:lang="en" font-size="12pt">
                        <xsl:text>LEMMA</xsl:text>
                        <xsl:text>&#xa;</xsl:text>
                        <xsl:text>&#x2028;</xsl:text>
                        <xsl:text>&#x2028;</xsl:text>
                    </fo:block>
                    <fo:table >
                        <fo:table-column column-width="40mm"/>
                        <fo:table-column column-width="120mm"/>
                        <fo:table-body>


                            <fo:table-row>
                                <fo:table-cell border-bottom="solid 1pt">
                                     <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                           <xsl:text>Vocalized Spelling</xsl:text>
                                    </fo:block>
                                 </fo:table-cell>
                                <fo:table-cell border-bottom="solid 1pt">
                                    <xsl:for-each select="mycoreobject/metadata/box.vocalized_spelling/vocalized_spelling">
                                         <xsl:if test="@xml:lang='he'">
                                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                              <xsl:value-of select = "." />
                                            </fo:block>
                                           </xsl:if>
                                        <xsl:if test="@xml:lang='en'">
                                             <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                 <xsl:value-of select = "." />
                                             </fo:block>
                                         </xsl:if>
                                    </xsl:for-each>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell>
                                <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                    <xsl:text>Grammatical information</xsl:text>
                                </fo:block>
                                </fo:table-cell>

                            </fo:table-row>
                            <xsl:if test="//box.root">

                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                            <xsl:text>Root</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="mycoreobject/metadata/box.root/root">
                                            <xsl:if test="@xml:lang='he'">
                                                <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                            <xsl:if test="@xml:lang='en'">
                                                <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>

                            </xsl:if>

                            <xsl:if test="//box.word_class_id">

                            <fo:table-row>
                                <fo:table-cell border-bottom="solid 1pt">
                                    <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                        <xsl:text>Word class</xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-bottom="solid 1pt">
                                    <xsl:for-each select="mycoreobject/metadata/box.word_class_id/word_class_id/@categid">
                                        <xsl:if test="@xml:lang='he'">
                                            <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                <xsl:value-of select = "." />
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="@xml:lang='en'">
                                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                <xsl:value-of select = "." />
                                            </fo:block>
                                        </xsl:if>
                                    </xsl:for-each>
                                </fo:table-cell>
                            </fo:table-row>

                            </xsl:if>

                            <xsl:if test="//box.root">

                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                            <xsl:text>Root</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="mycoreobject/metadata/box.root/root">
                                            <xsl:if test="@xml:lang='he'">
                                                <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                            <xsl:if test="@xml:lang='en'">
                                                <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>

                            </xsl:if>

                            <xsl:if test="//box.root">

                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                            <xsl:text>Root</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="mycoreobject/metadata/box.root/root">
                                            <xsl:if test="@xml:lang='he'">
                                                <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                            <xsl:if test="@xml:lang='en'">
                                                <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                            </xsl:if>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>

                            </xsl:if>

                            <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                <xsl:text>Index of definitions</xsl:text>
                            </fo:block>

                        </fo:table-body>
                    </fo:table>


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

                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet >