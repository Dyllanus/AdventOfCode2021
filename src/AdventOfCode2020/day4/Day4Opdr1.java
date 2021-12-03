package AdventOfCode2020.day4;

import day2.Utils;

import java.util.*;
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
                    great++;
                }else if (values.contains("cid")&& values.size()==1){
                    great++;
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
                    if (validatePasspoort(passpoort)) {
                        great++;
                    }
                }else if (values.contains("cid")&& values.size()==1){
                    if (validatePasspoort(passpoort)){
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

    private static boolean validatePasspoort(List<String> pass){
        String thingy = "amb blu brn gry grn hzl oth";
        String col = "#0123456789abcdef";
        List<String> ecl = new ArrayList<>(Arrays.asList(thingy.split(" ")));
        List<Character> hcl = new ArrayList<>();
        for (char ch: col.toCharArray()){
            hcl.add(ch);
        }
        for (String s: pass){
            String[] split = s.split(":");
            String key = split[0];
            String value = split[1];
            switch (key){
                case "byr":
                    int byr = Integer.parseInt(value);
                    if (!(byr>=1920 && byr<=2002)){
                        return false;
                    }
                    break;
                case "iyr":
                    int iyr = Integer.parseInt(value);
                    if (!(iyr>=2010 && iyr<=2020)){
                        return false;
                    }
                    break;
                case "eyr":
                    int eyr = Integer.parseInt(value);
                    if (!(eyr>=2020 && eyr<=2030)){
                        return false;
                    }
                    break;
                case "hgt":
                    String substring = value.substring(0, value.length() - 2);
                    if (substring.isEmpty()){
                        return false;
                    }
                    int height = Integer.parseInt(substring);
                    if (value.endsWith("cm")){
                        if (!(height>=150 && height<=193)){
                            return false;
                        }
                    }else if (value.endsWith("in")){
                        if (!(height>=59 && height<=76)){
                            return false;
                        }
                    }else{
                        return false;
                    }
                    break;
                case "hcl":
                    System.out.println(value);
                    if (value.length()!=7){
                        return false;
                    }
                    if (value.charAt(0)!='#'){
                        return false;
                    }
                    for (char c: value.toCharArray()){
                        if (!col.contains(String.valueOf(c))) {
                            return false;
                        }

                    }
                    break;
                case "ecl":
                    if (!ecl.contains(value)){
                        return false;
                    }
                    break;
                case "pid":
                    if (value.length()!=9){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
