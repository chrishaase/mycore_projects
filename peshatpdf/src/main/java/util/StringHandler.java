package main.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bietet einen String-Splitter an
 */

public class StringHandler {

    public static List csvStringSplitter (String csvString){

        String str[] = csvString.split(", ");
        List<String> arrayList = new ArrayList<String>();
        arrayList = Arrays.asList(str);


        return arrayList;

    }

}
