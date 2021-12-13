package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Jobo {
    int[][] map;
    boolean[][] flashMap = new boolean[10][10];
    long flash = 0;
    public void run(String path){
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            map = strings.stream().map(l -> l.chars()
                            .map(Character::getNumericValue).toArray())
                    .toArray(size -> new int[size][1]);
            int step= 0;
            int tegelijk = 0;
            while (true){
                flashMap = new boolean[10][10];
                for (int row = 0; row<map.length; row++){
                    for (int col = 0; col<map[row].length; col++){
                        checkXYcoords(col, row);
                    }
                }
               for (int row = 0; row<map.length; row++){
                    for (int col = 0; col<map[row].length; col++){
                        if (flashMap[row][col]){
                            tegelijk++;
                        }
                    }
                }
                step++;
               if (tegelijk==100){
                   break;
               }else{
                   tegelijk=0;
               }

            }

            System.out.println(step);


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
        if (!(x>= map[0].length || y >= map.length || y<0||x<0)){
            if (map[y][x]+1==10){
                map[y][x] = 0;
                flash++;
                flashMap[y][x]=true;
                flash(x,y);
            }else{
                if (!flashMap[y][x]) {
                    map[y][x]++;
                }
            }
        }
    }


    public static void main(String[] args) {
        Jobo jobo = new Jobo();
        jobo.run("src/day11/input.txt");
    }
}
