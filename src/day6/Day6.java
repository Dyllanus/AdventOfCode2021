package day6;

import day2.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    private static final List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        String path = "src/day6/input.txt";
        try {
            List<String> strings = Utils.readFileToStrings(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        opdracht1(list);
        opdracht2();
    }

    private static void opdracht1(List<Integer> ints) {
        List<Integer> lijst = new ArrayList<>(ints);
        int days=1;
        while(days<=80){
            lijst = beter(lijst);
            days++;
        }
        System.out.println(lijst.size());
    }

    private static void opdracht2() {
        String input = "5,3,2,2,1,1,4,1,5,5,1,3,1,5,1,2,1,4,1,2,1,2,1,4,2,4,1,5,1,3,5,4,3,3,1,4,1,3,4,4,1,5,4,3,3,2,5,1,1,3,1,4,3,2,2,3,1,3,1,3,1,5,3,5,1,3,1,4,2,1,4,1,5,5,5,2,4,2,1,4,1,3,5,5,1,4,1,1,4,2,2,1,3,1,1,1,1,3,4,1,4,1,1,1,4,4,4,1,3,1,3,4,1,4,1,2,2,2,5,4,1,3,1,2,1,4,1,4,5,2,4,5,4,1,2,1,4,2,2,2,1,3,5,2,5,1,1,4,5,4,3,2,4,1,5,2,2,5,1,4,1,5,1,3,5,1,2,1,1,1,5,4,4,5,1,1,1,4,1,3,3,5,5,1,5,2,1,1,3,1,1,3,2,3,4,4,1,5,5,3,2,1,1,1,4,3,1,3,3,1,1,2,2,1,2,2,2,1,1,5,1,2,2,5,2,4,1,1,2,4,1,2,3,4,1,2,1,2,4,2,1,1,5,3,1,4,4,4,1,5,2,3,4,4,1,5,1,2,2,4,1,1,2,1,1,1,1,5,1,3,3,1,1,1,1,4,1,2,2,5,1,2,1,3,4,1,3,4,3,3,1,1,5,5,5,2,4,3,1,4";
        long amount0 = 0;
        long amount1 = 0;
        long amount2 = 0;
        long amount3 = 0;
        long amount4 = 0;
        long amount5 = 0;
        for (int i = 0; i<7;i++){
            String[] strings = input.split(",");
            int count=0;
            for (String s: strings) {
                if (s.equals(String.valueOf(i))){
                    count++;
                }
            }
            if (i==1){
                amount1 = count;
            }else if (i==2){
                amount2 = count;
            }else if (i==3){
                amount3 = count;
            }else if (i==4){
                amount4 = count;
            }else if (i==5){
                amount5 = count;
            }
        }

        School school = new School(0, amount1,amount2, amount3, amount4,amount5,0,0,0);

        int days=1;
        while(days<=256){
            school.newDay();
            days++;
        }
        System.out.println();
        school.getTotalFish();

    }

    private static List<Integer> beter(List<Integer> ints){
        List<Integer> lijst = new ArrayList<>();
        for (int i: ints){
            if (i-1==-1){
                lijst.add(6);
                lijst.add(8);
            }else{
                lijst.add(i-1);
            }
        }
        return lijst;
    }
}
