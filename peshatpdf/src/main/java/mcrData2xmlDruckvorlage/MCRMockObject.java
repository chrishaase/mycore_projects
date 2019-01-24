package main.java.mcrData2xmlDruckvorlage;

import java.util.HashSet;

public class MCRMockObject {

    public static MCRLemma createMockLemma(){

        // Create Bib-Sources, Quotations and Definitions in reverse order

        MCRBibliographicalSource MCRBibliographicalSource0149 = new MCRBibliographicalSource();
        MCRBibliographicalSource0149.setMycoreid("peshat_bibliographical-sources_00000149");
        MCRBibliographicalSource0149.setAuthor("ha-Levi");
        MCRBibliographicalSource0149.setYear("1868");
        MCRBibliographicalSource0149.setTitle("Das Buch Kuzari");
        MCRBibliographicalSource0149.setPlace("Leipzig");
        MCRBibliographicalSource0149.setPublisher("Verlag von Fr. Voigt's Buchhandlung");

        MCRBibliographicalSource MCRBibliographicalSource0012 = new MCRBibliographicalSource();
        MCRBibliographicalSource0012.setMycoreid("peshat_bibliographical-sources_00000012");
        MCRBibliographicalSource0012.setAuthor("אברהם בן דאוד בן הלוי");
        MCRBibliographicalSource0012.setYear("1852");
        MCRBibliographicalSource0012.setTitle("ספר האמונה הרמה");
        MCRBibliographicalSource0012.setPlace("Frankfurt am Main");
        MCRBibliographicalSource0012.setPublisher("Typographische Anstalt");

        MCRQuotation MCRQuotation0028 = new MCRQuotation();
        MCRQuotation0028.setMycoreid("peshat_quotations_00000028");
        MCRQuotation0028.setQuotationText_he("אבות המעלות והחסרונות שלש");
        MCRQuotation0028.setMCRBibliographicalSources(new HashSet<MCRBibliographicalSource>());
        MCRQuotation0028.getMCRBibliographicalSources().add(MCRBibliographicalSource0012);

        MCRQuotation MCRQuotation5734 = new MCRQuotation();
        MCRQuotation5734.setMycoreid("peshat_quotations_00005734");
        MCRQuotation5734.setQuotationText_he(" סברתך ומחשבתך כאשר תרחיק המחשבה והסברא העדר הרקות וההקשות השכליות מחייבות זה וכאשר תרחיק הסברא שיכול להתחלק הגוף אין תכלית וההקשה השכלית מחייבת זה וכאשר תרחיק המחשבה שהארץ כדורית ושהיא חלק אחד ממאה וששים ושש פעמים מעגול השמש וכל מה שיש במופתי התכונה ממה שתרחיקהו המחשבה");
        MCRQuotation5734.setMCRBibliographicalSources(new HashSet<MCRBibliographicalSource>());
        MCRQuotation5734.getMCRBibliographicalSources().add(MCRBibliographicalSource0149);

        MCRDefinition MCRDefinition4668 = new MCRDefinition();
        MCRDefinition4668.setMycoreid("peshat_definitions_00004668");
        MCRDefinition4668.setDefinition_en("foundation, principle from which other things are derived");
        MCRDefinition4668.setMCRQuotations(new HashSet<MCRQuotation>());
        MCRDefinition4668.getMCRQuotations().add(MCRQuotation5734);

        MCRDefinition MCRDefinition4669 = new MCRDefinition();
        MCRDefinition4669.setMycoreid("peshat_definitions_00004669");
        MCRDefinition4669.setDefinition_en("something which encompasses many things (as a metaphor for abstract and spiritual things)");
        MCRDefinition4669.setMCRQuotations(new HashSet<MCRQuotation>());


        MCRDefinition MCRDefinition0013 = new MCRDefinition();
        MCRDefinition0013.setMycoreid("peshat_definitions_00000013");
        MCRDefinition0013.setDefinition_en("origin, cause");
        MCRDefinition0013.setMCRQuotations(new HashSet<MCRQuotation>());
        MCRDefinition0013.getMCRQuotations().add(MCRQuotation0028);

        // Create Lemma and add base Data

        MCRLemma MCRLemma1 = new MCRLemma();
        MCRLemma1.setMycoreid("peshat_lemmas_00000002");
        MCRLemma1.setGender("M");
        MCRLemma1.setVocalizedSpelling("אָב");
        MCRLemma1.setRoot("אבי");
        MCRLemma1.setVerbStem("Noun");

        // Add all Definitions to Lemma

        MCRLemma1.setListMCRDefinitions(new HashSet<MCRDefinition>());
        MCRLemma1.getListMCRDefinitions().add(MCRDefinition4668);
        MCRLemma1.getListMCRDefinitions().add(MCRDefinition4669);
        MCRLemma1.getListMCRDefinitions().add(MCRDefinition0013);

        // add all bib sources to extra List at the end of the Lemma


        MCRLemma1.setListMCRBibliographicalSources(new HashSet<MCRBibliographicalSource>());
        MCRLemma1.getListMCRBibliographicalSources().add(MCRBibliographicalSource0149);
        MCRLemma1.getListMCRBibliographicalSources().add(MCRBibliographicalSource0012);

        return MCRLemma1;
    }

}
