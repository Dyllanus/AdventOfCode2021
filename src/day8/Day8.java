package day8;

import day2.Utils;
import day6.School;

import java.util.*;

public class Day8 {

    public static void main(String[] args) {
        try{
//            opdracht1(Utils.readFileToStrings("src/day8/example.txt"));
//            opdracht1(Utils.readFileToStrings("src/day8/input.txt"));
//            opdracht2(Utils.readFileToStrings("src/day8/example.txt"));
            opdracht2(Utils.readFileToStrings("src/day8/input.txt"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void opdracht1(List<String> strings){
        int count = 0;
        for (String s: strings){
            for (String output: s.split("[|]")[1].split(" ")){
                if (!output.isEmpty()){
                    switch (output.length()) {
                        case 2, 3, 4, 7 -> count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    private static void opdracht2(List<String> strings) {
        Map<String, String> map = new HashMap<>();
        long antwoord = 0;
        for (String s: strings) {
            map = new HashMap<>(vulCijfersIn(s));
            String getal = "";
            for (String output: s.split("[|]")[1].split(" ")){
                if (!output.isEmpty()) {
                    char[] chars = output.toCharArray();
                    Arrays.sort(chars);
                    output = new String(chars);
                    if (output.equals(map.get("nul"))){
                        getal+="0";
                    }else if (output.equals(map.get("een"))){
                        getal+="1";
                    }else if (output.equals(map.get("twee"))){
                        getal+="2";
                    }else if (output.equals(map.get("drie"))){
                        getal+="3";
                    }else if(output.equals(map.get("vier"))) {
                        getal += "4";
                    }else if(output.equals(map.get("vijf"))){
                        getal+= "5";
                    }else if (output.equals(map.get("zes"))){
                        getal+="6";
                    }else if (output.equals(map.get("seven"))){
                        getal+="7";
                    }else if (output.equals(map.get("acht"))){
                        getal+="8";
                    }else if (output.equals(map.get("negen"))){
                        getal+="9";
                    }
                }
            }
            antwoord += Integer.parseInt(getal);
            map = new HashMap<>();
        }
        System.out.println(antwoord);
    }

    private static Map<String, String> vulCijfersIn(String s){
        Map<String, String> stringMap = new HashMap<>();
        for (String output: s.split("[|]")[0].split(" ")){
            if (!output.isEmpty()){
                switch (output.length()) {
                    case 2 -> {
                        stringMap.put("een", sort(output));
                    }
                    case 4 -> stringMap.put("vier", sort(output));
                    case 3 -> stringMap.put("seven", sort(output));
                    case 7 -> stringMap.put("acht", sort(output));
                }
            }
        }


        for (String output: s.split("[|]")[0].split(" ")){
            if (!output.isEmpty()){
                switch (output.length()) {
                    case 5 -> {
                        String een = stringMap.get("een");
                        int count=0;
                        for (char c: een.toCharArray()){
                            if (output.charAt(0) == c||output.charAt(1)==c|| output.charAt(2)==c || output.charAt(3)==c || output.charAt(4)==c){
                                count++;
                            }
                        }
                        if (count==2){
                            stringMap.put("drie", sort(output));
                        }
                    }
                    case 6 -> {
                        String een = stringMap.get("een");
                        int count=0;
                        for (char c: output.toCharArray()){
                            if (!(een.charAt(0)== c||een.charAt(1)==c)) {
                                count++;
                            }
                            if (count==5){
                                stringMap.put("zes", sort(output));
                            }
                        }

                        count = 0;
                        String vier = stringMap.get("vier");
                        for (char c: output.toCharArray()){
                            if (vier.charAt(0)== c || vier.charAt(1) == c || vier.charAt(2) == c || vier.charAt(3)==c){
                                count++;
                            }
                            if (count==4){
                                stringMap.put("negen", sort(output));
                            }
                        }

                    }
                }
            }
        }

        for (String output: s.split("[|]")[0].split(" ")) {
            if (!output.isEmpty()) {
                output = sort(output);
                if (!(output.equals(stringMap.get("zes")) || output.equals(stringMap.get("negen"))) && output.length() == 6) {
                    stringMap.put("nul", sort(output));
                }
                if (output.length()==5){
                    int count = 0;
                    for (char c: stringMap.get("zes").toCharArray()){
                        if (output.charAt(0) == c||output.charAt(1)==c|| output.charAt(2)==c || output.charAt(3)==c || output.charAt(4)==c){
                            count++;
                        }
                    }
                    if (count == 5) {
                        stringMap.put("vijf", sort(output));
                    }else{
                        if (!sort(output).equals(stringMap.get("drie"))) {
                            stringMap.put("twee", sort(output));
                        }
                    }
                }
            }
        }

        return stringMap;

    }
    private static String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
