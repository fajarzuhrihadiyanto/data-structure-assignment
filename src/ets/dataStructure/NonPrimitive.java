package ets.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents non primitive data types demonstration
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class NonPrimitive {

    /**
     * This is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        // STRING
        String name = "Fajar Zuhri Hadiyanto";
        System.out.println(name);

        // LIST (ARRAY LIST)
        List<Integer> scores = new ArrayList<>();
        scores.add(87);
        scores.add(90);
        scores.add(92);
        scores.add(84);
        System.out.println(scores.toString());

        // LINKED LIST
        LinkedList<String> faculty = new LinkedList<>();
        faculty.add("ELECTICS");
        faculty.add("SCIENTICS");
        faculty.add("MARTECH");
        faculty.add("INDSYS");
        faculty.add("CIVPLAN");
        faculty.add("CREABIZ");
        faculty.add("VOCATION");
        System.out.println(faculty.toString());
    }
}
