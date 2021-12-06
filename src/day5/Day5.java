package day5;

import day2.Utils;

import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        String path = "src/day5/input.txt";
        List<String> strings = Utils.readFileToStrings(path);

        opdracht1(strings);
//        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings) {
        for (String s: strings){
            String[] split = s.split(" -> ");
            int y=0;
            int y1=0;
            int x1=0;
            int x=0;
            boolean first = true;
            for (String string: split){
                String[] values = string.split(",");
                if (first){
                    x = Integer.parseInt(values[0]);
                    y = Integer.parseInt(values[1]);
                    first = false;
                }else{
                    x1 = Integer.parseInt(values[0]);
                    y1 = Integer.parseInt(values[1]);
                }
            }
            new Vents(x, x1, y, y1);
        }
        System.out.println(Vents.getPoints());
    }

    private static void opdracht2(List<String> strings) {

    }
}