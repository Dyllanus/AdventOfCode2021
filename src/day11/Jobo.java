package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Jobo {
    int[][] map = new int[10][10];
    long flash = 0;
    public void run(String path){
        try {
            int c = 0;
            int r = 0;
            List<String> strings = Files.readAllLines(Paths.get(path));
            for (String string: strings){
                for (char cc: string.toCharArray()){
                    map[r][c] = Integer.parseInt(String.valueOf(cc));
                    c++;
                }
                c =0;
                r++;
            }
            int step= 0;
            while (step<10){
                for (int row = 0; row<map.length; row++){
                    for (int col = 0; col<map[row].length; col++){
                        checkXYcoords(col, row);
                    }
                }
                printMatrix();
                step++;
            }

            System.out.println(flash);








        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // x en y coordinaten van de flash
    private void flash(int x, int y){
        checkXYcoords(x+1,y);
        checkXYcoords(x+1,y+1);
        checkXYcoords(x+1,y-1);
        checkXYcoords(x,y+1);
        checkXYcoords(x,y-1);
        checkXYcoords(x-1,y);
        checkXYcoords(x-1,y+1);
        checkXYcoords(x-1,y-1);
    }

    private void checkXYcoords(int x, int y){
        if (x>= map[0].length || y >= map.length || y<0||x<0){

        }else{
            if (map[y][x]+1==10){
                map[y][x] = 0;
                flash++;
                flash(x,y);


            }else{
                map[y][x]++;
            }

        }
    }
    public void printMatrix() {
        int[][] arr = map;
        int idx = -1;
        StringBuilder[] sbArr = new StringBuilder[map.length];
        int counter = 0;
        for (int[] row : arr) {
            sbArr[++idx] = new StringBuilder("(\t");

            for (long elem : row) {
                if (elem >= 2) counter++;
                sbArr[idx].append(elem).append("\t");
            }
            sbArr[idx].append(")");
        }
        for (StringBuilder stringBuilder : sbArr) {
            System.out.println(stringBuilder);
        }
        System.out.println("\nDONE\n" + " rows: " + counter);
    }

    public static void main(String[] args) {
        Jobo jobo = new Jobo();
        jobo.run("src/day11/example.txt");
    }
}
