<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" indent="yes"/>

    <xsl:template match="/">
        <xsl:text>&#xa;</xsl:text>
        <fo:root font-size="12pt" font-family="Cardo" xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <!-- oben - rechts - unten - links -->
                <fo:simple-page-master page-height="297mm" page-width="210mm"
                                       margin="5mm 5mm 5mm 5mm" master-name="PageMaster">
                    <fo:region-body margin="0mm 20mm 0mm 20mm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="PageMaster">


                <fo:flow flow-name="xsl-region-body" line-height="1.7" font-family="Cardo">

                    <fo:block text-align="center" line-height="40pt" start-indent = "10.0cm">
                        <fo:external-graphic height="auto" width="auto" content-height="auto"
                                             content-width="auto" src="/mycore/logo.jpg">
                        </fo:external-graphic>
                    </fo:block>



                    <fo:block text-align="center" xml:lang="en" font-size="12pt" font-style="italic">
                        <!--
                        <xsl:text>Philosophic and Scientific Hebrew Terminology in Context (PESHAT)</xsl:text>
                        -->
                        <xsl:text>A Thesaurus of Medieval Hebrew Philosophical Terminology</xsl:text>
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
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="110mm"/>
                        <fo:table-body>

                            <fo:table-row>
                                <fo:table-cell border-bottom="solid 1pt">
                                    <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                        <xsl:text>Vocalized Spelling</xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-bottom="solid 1pt">
                                    <xsl:for-each select="MCRLemma/vocalizedSpelling">
                                         <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                <xsl:value-of select = "." />
                                            </fo:block>
                                    </xsl:for-each>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <fo:table-row>
                                <fo:table-cell >
                                    <fo:block text-align="left" xml:lang="en" font-size="12pt" font-style="italic">
                                        <xsl:text>Grammatical Information</xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell >
                                    <fo:block  text-align="left" xml:lang="en" font-size="12pt">
                                        <xsl:text></xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <!-- root min occur:0 max occur 1-->
                            <xsl:if test="MCRLemma/root">
                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" >
                                            <xsl:text>&#8226; Root</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="MCRLemma/root">
                                               <fo:block text-align="right" xml:lang="he" font-size="12pt">
                                                    <xsl:value-of select = "." />
                                                </fo:block>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:if>

                            <!-- word_class_id min occur:1 max occur 1-->
                            <xsl:if test="MCRLemma/wordClass">
                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" >
                                            <xsl:text>&#8226; Word Class</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="MCRLemma/wordClass">
                                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                <xsl:value-of select = "."/>
                                            </fo:block>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:if>

                            <!-- gender_id min occur:0 max:0 -->
                            <xsl:if test="MCRLemma/gender">
                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" >
                                            <xsl:text>&#8226; Gender</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="MCRLemma/gender">
                                                <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                <xsl:value-of select = "." />
                                            </fo:block>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:if>

                            <!-- verb_stem_id min occur:0 max:0 -->
                            <xsl:if test="MCRLemma/verbStem">
                                <fo:table-row>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" >
                                            <xsl:text>&#8226; VerbStem</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-bottom="solid 1pt">
                                        <xsl:for-each select="MCRLemma/verbStem">
                                            <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                <xsl:value-of select = "."/>
                                            </fo:block>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:if>

                            <fo:table-row>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                            </fo:table-row>


                            <!-- definitionS -->
                            <xsl:if test="MCRLemma/definition">

                                <fo:table-row>
                                    <fo:table-cell >
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" font-style="italic">
                                            <xsl:text>Definitions:</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell >
                                        <fo:block  text-align="left" xml:lang="en" font-size="12pt">
                                            <xsl:text></xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>


                                <xsl:for-each select="MCRLemma/definition">

                                    <!-- definition-->

                                <fo:table-row>
                                    <fo:table-cell border-top="solid 1pt">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt" >
                                            <xsl:text>Definition</xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-top="solid 1pt">
                                              <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                <xsl:value-of select = "definition_en"/>
                                            </fo:block>
                                        </fo:table-cell>
                                </fo:table-row>

                                    <!-- QuotationS -->

                                    <xsl:if test="quotation">

                                        <xsl:for-each select="quotation">

                                    <!-- MCRQuotation -->

                                            <fo:table-row>
                                                <fo:table-cell >
                                                    <fo:block text-align="left" xml:lang="en" font-size="12pt" font-style="italic" white-space-collapse="false" white-space-treatment="preserve">
                                                        <xsl:text>Quote</xsl:text>
                                                    </fo:block>
                                                </fo:table-cell>

                                                   <fo:table-cell >
                                                    <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                        <xsl:value-of select = "quotationText_he"/>
                                                    </fo:block>
                                                </fo:table-cell>
                                         </fo:table-row>

                                            <!-- MCRBibliographicalSource -->

                                            <fo:table-row>
                                                <fo:table-cell border-bottom="solid 1pt"  >
                                                <fo:block white-space-collapse="false" white-space-treatment="preserve">
                                                    <xsl:text>Source</xsl:text>
                                                </fo:block>
                                                </fo:table-cell>

                                                <fo:table-cell border-bottom="solid 1pt">
                                                    <fo:block text-align="right" xml:lang="en" font-size="12pt">
                                                        <xsl:value-of select = "bibliographicalSource/author"/>
                                                        <xsl:text> : </xsl:text>
                                                        <xsl:value-of select = "bibliographicalSource/title"/>
                                                        <xsl:text> ( </xsl:text>
                                                        <xsl:value-of select = "bibliographicalSource/translator"/>
                                                        <xsl:text>) </xsl:text>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>


                                    <!--end quotationS -->
                                        </xsl:for-each>
                                    </xsl:if>

                                    <!-- footer definitionS -->
                                </xsl:for-each>
                            </xsl:if>


                            <fo:table-row>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                                <fo:table-cell >
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                        <!-- Bibliography -->




                            <!-- sourceS-->
                            <xsl:if test="MCRLemma/bibliographicalSource">

                            <fo:table-row>
                                <fo:table-cell >
                                    <fo:block text-align="left" xml:lang="en" font-size="12pt" font-style="italic">
                                        <xsl:text>Sources:</xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell >
                                    <fo:block  text-align="left" xml:lang="en" font-size="12pt">
                                        <xsl:text></xsl:text>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>

                            <xsl:for-each select="MCRLemma/bibliographicalSource">

                                <!-- source-->
                                <fo:table-row>

                                    <fo:table-cell number-columns-spanned="2">
                                        <fo:block text-align="left" xml:lang="en" font-size="12pt">
                                            <xsl:value-of select = "author"/>
                                            <xsl:text> (</xsl:text>
                                            <xsl:value-of select = "year"/>
                                            <xsl:text>) : </xsl:text>
                                            <xsl:value-of select = "title"/>
                                            <xsl:text> ( </xsl:text>
                                            <xsl:value-of select = "place"/>
                                            <xsl:text>: </xsl:text>
                                            <xsl:value-of select = "publisher"/>
                                            <xsl:text>) </xsl:text>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>


                            <!-- end sourceS -->
                            </xsl:for-each>
                            </xsl:if>

                        </fo:table-body>
                    </fo:table>



                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet >