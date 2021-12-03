package AdventOfCode2020.day3;

import day2.Utils;

import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        String path = "src/AdventOfCode2020/day3/input.txt";
        List<String> strings = Utils.readFileToStrings(path);

        opdracht1(strings);
        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int x = 0;
        int y = 0;
        int trees = 0;
        boolean first = true;
        for (String s:strings){
            System.out.println(s);
            if(first){
                x+=5;
                first = false;
                continue;
            }
            char tree = s.charAt(x);
            if (tree == '#'){
                trees++;
            }
            if (x+5>s.length()-1){
                x = x-s.length()+5;
            }else {
                x += 5;
            }
        }
        System.out.println(trees);
    }

    private static void opdracht2(List<String> strings){
        System.out.println((long)calculateTrees(1,1, strings) * calculateTrees(5,1,strings) * calculateTrees(3,1,strings) * calculateTrees(7,1,strings) * calculateTrees(1,2, strings) );
    }

    private static int calculateTrees(int x, int y, List<String> strings){
        int trees = 0;
        int right= 0;
        int down = 0;
        boolean first = true;
        for(int i = 0;i< strings.size(); i+=y){
            if(first){
                right+=x;
                down+=y;
                first = false;
                continue;
            }
            char tree = strings.get(i).charAt(right);
            if (tree == '#') {
                trees++;
            }

            if (right + x > strings.get(i).length() - 1) {
                right = right - strings.get(i).length() + x;
            } else {
                right += x;
            }
        }


        return trees;

    }
}
