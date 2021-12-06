package day4;

import day2.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        String path = "src/day4/input.txt";
        List<String> strings = Utils.readFileToStrings(path);

        opdracht1(strings);
//        opdracht2(strings);
    }

    private static void opdracht1(List<String> strings){
        int[][] matrix = new int[5][5];

        int counter = 0;
        for (String regel:strings){
            if (regel.startsWith(" ")){
                regel = regel.trim();
            }
            String[] string = regel.split("\\s+");
            if (string.length==1){
                new BingoKaart(matrix);
                counter = 0;
                matrix= new int[5][5];
            }else {
                for (int i=0; i<string.length;i++){
                    matrix[counter][i] = Integer.parseInt(string[i]);
                }
                counter++;
            }
        }
        String ints = "99,56,7,15,81,26,75,40,87,59,62,24,58,34,78,86,44,65,18,94,20,17,98,29,57,92,14,32,46,79,85,84,35,68,55,22,41,61,90,11,69,96,23,47,43,80,72,50,97,33,53,25,28,51,49,64,12,63,21,48,27,19,67,88,66,45,3,71,16,70,76,13,60,77,73,1,8,10,52,38,36,74,83,2,37,6,31,91,89,54,42,30,5,82,9,95,93,4,0,39";
//        ints = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        List<Integer> getallen = new ArrayList<>();
        for (String s: ints.split(",")){
            getallen.add(Integer.parseInt(s));
        }
        System.out.println(BingoKaart.spelen(getallen));
    }

    private static void opdracht2(List<String> strings){

    }
}
