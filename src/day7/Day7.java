package day7;

import day2.Utils;
import day6.School;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {
    public static void main(String[] args) {
        String path = "src/day7/input.txt";
        String path1 = "src/day7/example.txt";
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            for (String cijfer: line.split(",")) {
                list.add(Integer.parseInt(cijfer));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        Integer[] hey = new Integer[list.size()];
        list.toArray(hey);
//        opdracht1(hey);
        opdracht2(list);

    }

    private static void opdracht1(Integer[] numArray) {
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0)
            median = ((double)numArray[numArray.length/2] + (double)numArray[numArray.length/2 - 1])/2;
        else
            median = (double) numArray[numArray.length/2];
        int mediaan =(int) median;


        int fuel=0;
        for (int i: numArray){
            fuel += Math.abs(mediaan-i);
        }
        System.out.println(fuel);


    }

    private static void opdracht2(ArrayList<Integer> numArray) {
        double gemiddelde = numArray.stream().mapToDouble(value -> value).average().getAsDouble();
        System.out.println(gemiddelde);
        long average = Math.round(gemiddelde)-1;
        long fuel = 0;
        for (int i: numArray){
            long ant = Math.abs(average-i);
            int count = 1;
            for (long it =ant;it>=1;it--){
                fuel+=count;
                count++;
            }
        }
        System.out.println(fuel);
    }
}
