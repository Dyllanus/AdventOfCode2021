package day9;

import day2.Utils;

import java.util.List;

public class Day9 {
    public static void main(String[] args) {
        String path = "src/day9/input.txt";
        String path1 = "src/day9/example.txt";
        try{
            opdracht1(Utils.readFileToStrings(path));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
    check links, rechts, boven en onder van het getal
     */
    private static void opdracht1(List<String> strings){
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
        int count=0;
        int rowCount = 0;
        int antwoord=0;
        boolean firstrow = true;
        boolean firstcol = true;
        for (int row=0; row<ints.length; row++){
            for (int col=0; col<ints[row].length;col++){
                int getal = ints[row][col];
                if (firstrow){
                    if (firstcol) {
                        if (ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            antwoord += getal+1;
                        }
                        firstcol=false;
                    } else if (count==99) {
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal){
                            antwoord+=getal+1;
                        }
                    }else{
                        if (ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            antwoord += getal+1;
                        }
                    }
                }else {
                    if (count==99){
                        if (ints[row][col - 1] > getal && ints[row + 1][col] > getal && ints[row - 1][col] > getal){
                            antwoord+=getal+1;
                        }
                    } else if (firstcol){
                        if (ints[row-1][col] > getal && ints[row][col+1] > getal && ints[row+1][col] > getal){
                            antwoord+=getal+1;
                        }
                        firstcol=false;
                    }else {
                        if (rowCount==99){
                            if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal){
                                antwoord+=getal+1;
                            }
                        } else if (ints[row - 1][col] > getal && ints[row][col - 1] > getal && ints[row][col + 1] > getal && ints[row + 1][col] > getal) {
                            antwoord += getal+1;
                        }
                    }
                }
                count++;
            }
            System.out.println("hey");
            count = 0;
            rowCount++;
            firstrow = false;
            firstcol = true;
        }

        System.out.println(antwoord);
    }

    private static void printMatrix(int[][] f){
        for (int y=0; y<f.length; y++){
            for (int j=0; j<f[y].length;j++){
                System.out.print(f[y][j]+ " ");
            }
            System.out.println();
        }
    }
}
