package AdventOfCode2020.day5;

import day2.Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {
    public static void main(String[] args) {
        String path = "src/AdventOfCode2020/day5/input1.txt";
        List<String> strings = Utils.readFileToStrings(path);

        opdracht1(strings);
//        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int seatID = 0;
//        List<Integer> range = IntStream.rangeClosed(0, 127)
//                .boxed().collect(Collectors.toList());
//        System.out.println(range);
        for (String s:strings){
            int row = 0;
            int kolom = 0;
            for (char c: s.toCharArray()){
                if (c=='F'){
                }else if(c=='B'){
                }else if (c=='L'){

                }else if (c=='R'){

                }
            }

            int antwoord = row * 8 + kolom;
            if (antwoord>seatID){
                seatID = antwoord;
            }
        }
        System.out.println();
    }

    private static void opdracht2(List<String> strings){

    }

}
