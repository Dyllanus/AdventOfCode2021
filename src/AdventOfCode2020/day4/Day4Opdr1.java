package AdventOfCode2020.day4;

import day2.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Opdr1 {
    public static void main(String[] args) {
        String path = "src/AdventOfCode2020/day4/input.txt";
        List<String> strings = Utils.readFileToStrings(path);
//        List<Integer> integers = Utils.readFileToIntegers(path);
//        opdracht1(strings);
        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int great = 0;
        String v = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
        List<String> values = new ArrayList<>(Arrays.asList(v.split(",")));
        List<String> passpoort = new ArrayList<>();
        for (String string: strings){
            if (string.isBlank()){
                for (String s : passpoort) {
                    values.remove(s.split(":")[0]);
                }
                values.forEach(System.out::println);
                if (values.isEmpty()){
                    if (testValues(passpoort)) {
                        great++;
                    }
                }else if (values.contains("cid")&& values.size()==1){
                    if (testValues(passpoort)) {
                        great++;
                    }
                }
                values = new ArrayList<>(Arrays.asList(v.split(",")));
                passpoort = new ArrayList<>();
            }else{
                String[] val = string.split(" ");
                passpoort.addAll(Arrays.asList(val));

            }
        }
        System.out.println(great);
    }

    private static void opdracht2(List<String> strings){
        int great = 0;
        String v = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
        List<String> values = new ArrayList<>(Arrays.asList(v.split(",")));
        List<String> passpoort = new ArrayList<>();
        for (String string: strings){
            if (string.isBlank()){
                for (String s : passpoort) {
                    values.remove(s.split(":")[0]);
                }
                if (values.isEmpty()){
                    if (testValues(passpoort)) {
                        great++;
                    }
                }else if (values.contains("cid")&& values.size()==1){
                    if (testValues(passpoort)) {
                        great++;
                    }
                }
                values = new ArrayList<>(Arrays.asList(v.split(",")));
                passpoort = new ArrayList<>();
            }else{
                String[] val = string.split(" ");
                passpoort.addAll(Arrays.asList(val));

            }
        }
        System.out.println(great+1);
    }

    private static boolean testValues(List<String> passpoort){
        // TODO: 01/12/2021 implement this method
        // https://adventofcode.com/2020/day/4#part2
        boolean valid = true;
        String ecl = "amb,blu,brn,gry,grn,hzl,oth";
        String color = "0123456789abcdef";

        List<String> eclList = new ArrayList<>(Arrays.asList(ecl.split(",")));
        List<Character> hclList = new ArrayList<>();
        for (char ca: color.toCharArray()){
            hclList.add(ca);
        }
        eclList.forEach(System.out::println);
        System.out.println();
       A: for (String s:passpoort){
            String[] sSplit = s.split(":");
            switch (sSplit[0]){
                case "byr":
                    int i = Integer.parseInt(sSplit[1]);
                    if (!(i>=1920 && i<=2002)){
                        valid=false;
                        break A;
                    }
                    break;
                case "iyr":
                    int in = Integer.parseInt(sSplit[1]);
                    if (!(in>=2010 && in<=2020)){
                        valid=false;
                        break A;
                    }
                    break;
                case "eyr":
                    int inte = Integer.parseInt(sSplit[1]);
                    if (!(inte>=2020 && inte<=2030)){
                        valid=false;
                        break A;
                    }
                    break;
                case "hgt":
                    String measurement = sSplit[1].substring(sSplit[1].length()-2);
                    if (measurement.equals("in")){
                        int length = Integer.parseInt(sSplit[1].substring(0,sSplit[1].length()-2));
                        if (length>=59 && length<=76){
                            continue;
                        }
                    }else if (measurement.equals("cm")){
                        int length = Integer.parseInt(sSplit[1].substring(0,sSplit[1].length()-2));
                        if (length>=150 && length<=193){
                            continue;
                        }
                    }
                    valid = false;
                    break A;
                case "hcl":
//                    if (sSplit[1].charAt(0)=='#'&& sSplit[1].length()==7){
//                        for (char c: sSplit[1].toCharArray()){
//                            if (!hclList.contains(c)){
//                                valid=  false;
//                                break A;
//                            }
//                        }
//                    }
//                    valid=  false;
//                    break A;
                case "ecl":
                    System.out.println(sSplit[1]);

                    if (!eclList.contains(sSplit[1])){
                        valid=false;
                        break A;
                    }
                    break;
                case "pid":
                    if (sSplit[1].length()!=9){
                        valid = false;
                        break A;
                    }
                    break;
            }
        }
        return valid;
    }
}
