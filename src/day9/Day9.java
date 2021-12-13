package day9;

import day2.Utils;

import java.util.*;

public class Day9 {
    public static void main(String[] args) {
        String path = "src/day9/input.txt";
        String path1 = "src/day9/example.txt";
        try{
//            opdracht1(Utils.readFileToStrings(path));
            opdracht2(Utils.readFileToStrings(path1));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
    check links, rechts, boven en onder van het getal
     */
    private static Map<Integer, String> opdracht1(List<String> strings){
        int[][] ints = vanListToMatrix(strings);
        int count=0;
        int rowCount = 0;
        int antwoord=0;
        boolean firstrow = true;
        boolean firstcol = true;
        Map<Integer, String> coords = new HashMap<>();
        for (int row=0; row<ints.length; row++){
            for (int col=0; col<ints[row].length;col++){
                int getal = ints[row][col];
                if (firstrow){
                    if (firstcol) {
                        if (ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                        firstcol=false;
                    } else if (count==99) {
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                    }else{
                        if (ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                    }
                }else {
                    if (count==99){
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal && ints[row - 1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                    } else if (firstcol){
                        if (ints[row-1][col] > getal && ints[row][col+1] > getal && ints[row+1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                        firstcol=false;
                    }else {
                        if (rowCount==99){
                            if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal){
                                coords.put(rowCount+count, String.format("%s, %s", row, col));
                                antwoord+=getal+1;
                            }
                        } else if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                    }
                }
                count++;
            }
            count = 0;
            rowCount++;
            firstrow = false;
            firstcol = true;
        }

        System.out.println(antwoord);
        return coords;
    }

    private static void opdracht2(List<String> strings){
        int[][] ints = vanListToMatrix(strings);
        List<List<String>> integers = new ArrayList<>();
        Map<Integer, String> coords = new HashMap<>(example(strings));
        for (int i: coords.keySet()) {
            int row = Integer.parseInt(coords.get(i).split(", ")[0]);
            int col = Integer.parseInt(coords.get(i).split(", ")[1]);
            System.out.println(ints[row][col]);
            int checkRow = row;
            int checkCol = col;
            int number = ints[row][col];
            while (true) {
                if (row == 0) {

                } else if (col == 0) {

                } else {

                }
            }
        }

        System.out.println(integers);
    }


    private static int[][] vanListToMatrix(List<String> strings){
        int[][] ints = new int[100][100];
        int rows = 0;
        int column=0;
        for (String s: strings){
            for (String c: s.split("")){
                ints[rows][column] = Integer.parseInt(c);
                column++;
            }
            column=0;
            rows++;
        }
        return ints;
    }

    private static Map<Integer, String> example(List<String>strings){
        int[][] ints = new int[5][10];
        int rows = 0;
        int column=0;
        for (String s: strings){
            for (String c: s.split("")){
                ints[rows][column] = Integer.parseInt(c);
                column++;
            }
            column=0;
            rows++;
        }
        int count=0;
        int rowCount = 0;
        int antwoord=0;
        boolean firstrow = true;
        boolean firstcol = true;
        Map<Integer, String> coords = new HashMap<>();
        for (int row=0; row<ints.length; row++){
            for (int col=0; col<ints[row].length;col++){
                int getal = ints[row][col];
                if (firstrow){
                    if (firstcol) {
                        if (ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                        firstcol=false;
                    } else if (count==9) {
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                    }else{
                        if (ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                    }
                }else {
                    if (count==9){
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal && ints[row - 1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                    } else if (firstcol){
                        if (ints[row-1][col] > getal && ints[row][col+1] > getal && ints[row+1][col] > getal){
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord+=getal+1;
                        }
                        firstcol=false;
                    }else {
                        if (rowCount==4){
                            if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal){
                                coords.put(rowCount+count, String.format("%s, %s", row, col));
                                antwoord+=getal+1;
                            }
                        } else if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            coords.put(rowCount+count, String.format("%s, %s", row, col));
                            antwoord += getal+1;
                        }
                    }
                }
                count++;
            }
            count = 0;
            rowCount++;
            firstrow = false;
            firstcol = true;
        }
        System.out.println(antwoord);
        return coords;
    }
}
