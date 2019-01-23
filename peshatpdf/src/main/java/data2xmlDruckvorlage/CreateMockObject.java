package main.java.data2xmlDruckvorlage;

import java.util.ArrayList;

public class CreateMockObject {

    public static Lemma createMockLemma(){

        BibliographicalSource bibliographicalSource0149 = new BibliographicalSource();
        bibliographicalSource0149.setMycoreid("peshat_bibliographical-sources_00000149");
        bibliographicalSource0149.setAuthor("ha-Levi");
        bibliographicalSource0149.setYear("1868");
        bibliographicalSource0149.setTitle("Das Buch Kuzari");
        bibliographicalSource0149.setPlace("Leipzig");
        bibliographicalSource0149.setPublisher("Verlag von Fr. Voigt's Buchhandlung");
        bibliographicalSource0149.setTranslator("Translator2");

        BibliographicalSource bibliographicalSource0012 = new BibliographicalSource();
        bibliographicalSource0012.setMycoreid("peshat_bibliographical-sources_00000012");
        bibliographicalSource0012.setAuthor("אברהם בן דאוד בן הלוי");
        bibliographicalSource0012.setYear("1852");
        bibliographicalSource0012.setTitle("ספר האמונה הרמה");
        bibliographicalSource0012.setPlace("Frankfurt am Main");
        bibliographicalSource0012.setPublisher("Typographische Anstalt");
        bibliographicalSource0012.setTranslator("Translator1");


        Quotation quotation0028 = new Quotation();
        quotation0028.setMycoreid("peshat_quotations_00000028");
        quotation0028.setQuotationText_he("אבות המעלות והחסרונות שלש");
        quotation0028.setPages("Passage 2-3");
        quotation0028.setBibliographicalSources(new ArrayList<BibliographicalSource>());
        quotation0028.getBibliographicalSources().add(bibliographicalSource0012);

        Quotation quotation5734 = new Quotation();
        quotation5734.setMycoreid("peshat_quotations_00005734");
        quotation5734.setQuotationText_he(" סברתך ומחשבתך כאשר תרחיק המחשבה והסברא העדר הרקות וההקשות השכליות מחייבות זה וכאשר תרחיק הסברא שיכול להתחלק הגוף אין תכלית וההקשה השכלית מחייבת זה וכאשר תרחיק המחשבה שהארץ כדורית ושהיא חלק אחד ממאה וששים ושש פעמים מעגול השמש וכל מה שיש במופתי התכונה ממה שתרחיקהו המחשבה");
        quotation5734.setPages("Seite 2");
        quotation5734.setBibliographicalSources(new ArrayList<BibliographicalSource>());
        quotation5734.getBibliographicalSources().add(bibliographicalSource0149);

        Definition definition4668 = new Definition();
        definition4668.setMycoreid("peshat_definitions_00004668");
        definition4668.setDefinition_en("foundation, principle from which other things are derived");
        definition4668.setQuotations(new ArrayList<Quotation>());
        definition4668.getQuotations().add(quotation5734);

        Definition definition4669 = new Definition();
        definition4669.setMycoreid("peshat_definitions_00004669");
        definition4669.setDefinition_en("something which encompasses many things (as a metaphor for abstract and spiritual things)");
        definition4669.setQuotations(new ArrayList<Quotation>());


        Definition definition0013 = new Definition();
        definition0013.setMycoreid("peshat_definitions_00000013");
        definition0013.setDefinition_en("origin, cause");
        definition0013.setQuotations(new ArrayList<Quotation>());
        definition0013.getQuotations().add(quotation0028);

        Lemma lemma1 = new Lemma();
        lemma1.setMycoreid("peshat_lemmas_00000002");
        lemma1.setGender("M");
        lemma1.setVocalizedSpelling("אָב");
        lemma1.setRoot("אבי");
        lemma1.setVerbStem("Noun");
        lemma1.setListDefinitions(new ArrayList<Definition>());
        lemma1.getListDefinitions().add(definition4668);
        lemma1.getListDefinitions().add(definition4669);
        lemma1.getListDefinitions().add(definition0013);
        lemma1.setListBibliographicalSources(new ArrayList<BibliographicalSource>());
        lemma1.getListBibliographicalSources().add(bibliographicalSource0149);
        lemma1.getListBibliographicalSources().add(bibliographicalSource0012);

        return lemma1;
    }

}
