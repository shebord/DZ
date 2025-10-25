package prac10_to_19.prac13;

import java.io.*;
import java.util.*;

public class prac13_6 {

    public static String getLine(String... words) {
        if (words.length == 0) return "";

        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder(list.remove(0));

        boolean found;
        do {
            found = false;
            char lastChar = Character.toLowerCase(result.charAt(result.length() - 1));

            for (int i = 0; i < list.size(); i++) {
                String word = list.get(i);
                if (Character.toLowerCase(word.charAt(0)) == lastChar) {
                    result.append(" ").append(word);
                    list.remove(i);
                    found = true;
                    break;
                }
            }
        } while (found);

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = fileReader.readLine();
        fileReader.close();

        String[] words = line.split(" ");
        System.out.println(getLine(words));
    }
}
