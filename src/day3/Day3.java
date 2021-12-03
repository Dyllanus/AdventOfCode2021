package day3;

import day2.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        String path = "src/day3/input.txt";
        List<String> strings = Utils.readFileToStrings(path);


//        opdracht1(strings);
        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<12; i++){
            list.add(0);
        }
        int counter = 0;
        for (String s: strings){
            for (char c: s.toCharArray()){
                if (c=='1'){
                    list.set(counter, list.get(counter)+1);
                }
                counter++;
            }
            counter = 0;
        }

        List<String> string = new ArrayList<>();
        list.forEach(i -> {
            if (i>=500){
                string.add("1");
            }else{
                string.add("0");
            }
        });
        string.forEach(System.out::print);
        // 101110101011 * 010001010100
        // 2987 * 1108
    }

    private static void opdracht2(List<String> strings){
        int counter = 0;
        List<String> oxygenGenerator = oxygenGenerator(strings, counter);
        while (oxygenGenerator.size() !=1){
            counter++;
            oxygenGenerator = oxygenGenerator(oxygenGenerator, counter);
        }
        System.out.println(oxygenGenerator);


        counter=0;
        List<String> co2Scrubber=  co2Scrubber(strings, counter);
        while(co2Scrubber.size()!=1){
            counter++;
            co2Scrubber = co2Scrubber(co2Scrubber, counter);
        }
        System.out.println(co2Scrubber);

    }

    private static List<String> oxygenGenerator(List<String> strings, int kolom) {
        List<String> oneList = new ArrayList<>();
        List<String> zeroList = new ArrayList<>();

        for (String s : strings) {
            if (s.charAt(kolom) == '1') {
                oneList.add(s);
            } else {
                zeroList.add(s);
            }
        }
        if (oneList.size() >= zeroList.size()) {
            return oneList;
        } else {
            return zeroList;
        }
    }
        private static List<String> co2Scrubber(List<String> strings, int kolom){
            List<String> oneList = new ArrayList<>();
            List<String> zeroList = new ArrayList<>();

            for (String s: strings){
                if (s.charAt(kolom)== '1'){
                    oneList.add(s);
                }else{
                    zeroList.add(s);
                }
            }
            if (oneList.size() >= zeroList.size()){
                return zeroList;
            }else {
                return oneList;
            }
    }

}
