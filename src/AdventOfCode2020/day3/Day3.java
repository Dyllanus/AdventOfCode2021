package AdventOfCode2020.day3;

import day2.Utils;

import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        String path = "src/AdventOfCode2020/day3/input.txt";
        List<String> strings = Utils.readFileToStrings(path);


        opdracht1(strings);
//        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int x = 0;
        int y = 0;
        int trees = 0;
        boolean first = true;
        for (String s:strings){
            System.out.println(s);
            if(first){
                x+=3;
                y+=1;
                first = false;
                continue;
            }
            char tree = s.charAt(x);
            if (tree == '#'){
                trees++;
            }
            if (x+3>s.length()-1){
                x = x-s.length()+3;
            }else {
                x += 3;
            }
        }
        System.out.println(trees);
    }

    private static void opdracht2(List<String> strings){
    }
}
