package day2;

import java.util.List;

public class Day2Opdr1 {
    public static void main(String[] args) {
        String path = "src/day2/input.txt";
        List<String> strings = Utils.readFileToStrings(path);


//        opdracht1(strings);
        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int depth = 0;
        int hor = 0;
        for (String regel: strings){
            String direction = regel.split(" ")[0];
            int hoeveel = Integer.parseInt(regel.split(" ")[1]);
            switch (direction) {
                case "up" -> depth -= hoeveel;
                case "down" -> depth += hoeveel;
                case "forward" -> hor += hoeveel;
            }
        };
        System.out.println(hor* depth);
    }

    private static void opdracht2(List<String> strings){
        int depth = 0;
        int hor = 0;
        int aim= 0;
        for (String regel: strings){
            String direction = regel.split(" ")[0];
            int hoeveel = Integer.parseInt(regel.split(" ")[1]);
            switch (direction) {
                case "up" -> aim -= hoeveel;
                case "down" -> aim += hoeveel;
                case "forward" -> {
                    hor += hoeveel;
                    depth += hoeveel * aim;
                }
            }
        };
        System.out.println(hor* depth);
    }

}
