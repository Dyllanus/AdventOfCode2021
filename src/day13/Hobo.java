package day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Hobo {
    public static final String RED = "\033[0;31m";     // RED
    public static final String RESET = "\033[0m";  // Text Reset


    int[][] matrix = new int[10][40];
    private void test(String path, String folds){
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            List<String> fold = Files.readAllLines(Paths.get(folds));
            for (String s: fold){
                strings = foldPaper(strings, s);
            }

            Set<String> antwoord = new HashSet<>(strings);
            for (String s:antwoord){
                String[] split = s.split(",");
                matrix[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 8;
            }

            print();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<String> foldPaper(List<String> strings, String fold){
        List<String> newList = new ArrayList<>();
        String[] foldSplit = fold.split("=");
        for (String s: strings){
            String[] stringSplit = s.split(",");
            if (foldSplit[0].equals("y")){
                if (Integer.parseInt(stringSplit[1])<Integer.parseInt(foldSplit[1])){
                    newList.add(s);
                }else{
                    int verschil = Integer.parseInt(stringSplit[1])-(Integer.parseInt(foldSplit[1]));
                    newList.add(stringSplit[0] +","+(Integer.parseInt(foldSplit[1])- verschil));
                }
            }else{
                if (Integer.parseInt(stringSplit[0])<Integer.parseInt(foldSplit[1])){
                    newList.add(s);
                }else{
                    int verschil = Integer.parseInt(stringSplit[0])-(Integer.parseInt(foldSplit[1]));
                    newList.add((Integer.parseInt(foldSplit[1]) - verschil +","+stringSplit[1]));
                }
            }
        }
        return newList;
    }

    private void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]!=0) {
                    System.out.print(RED+matrix[i][j] + " ");
                }else{
                    System.out.print(RESET+matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Hobo hobo = new Hobo();
        hobo.test("src/day13/input.txt", "src/day13/fold.txt");
    }
}
