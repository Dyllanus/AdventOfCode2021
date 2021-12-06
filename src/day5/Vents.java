package day5;

import java.util.ArrayList;
import java.util.List;

public class Vents {
    private static long[][] lijnen=  new long[1000][1000];
    private static List<Vents> vents = new ArrayList<>();
    private int x, x1;
    private int y, y1;

    public Vents(int x, int x1, int y,int y1){
        this.x = x;
        this.x1 = x1;
        this.y = y;
        this.y1 = y1;
        setCordsInLijnen();
        vents.add(this);
    }

    private void setCordsInLijnen(){
        if (x==x1){
            if (y > y1){
                for (int i =y1; i<=y;i++){
                    lijnen[i][x]++;
                }
            }else{
                for (int i =y; i<=y1;i++){
                    lijnen[i][x]++;
                }
            }
        }else if(y==y1){
            if (x>x1){
                for (int i=x1;i<=x;i++){
                    lijnen[y][i]++;
                }
            }else{
                for (int i=x;i<=x1;i++){
                    lijnen[y][i]++;
                }
            }
        }else{
            if (x> x1 && y<y1) {
                //GOED
                int count = 0;
                for (int i = x1; i <= x; i++) {
                    lijnen[y1+count][i]++;
                    count--;
                }
            }else if (x<x1 && y<y1){
                int count = 0;
                for (int i =x; i<=x1;i++){
                    lijnen[y+count][i]++;
                    count++;
                }

            }else if (x<x1){
                int count = 0;
                for (int i=x; i<=x1;i++){
                    lijnen[y+count][i]++;
                    count--;
                }

            }else if (x>x1 && y>y1){
                int count = 0;
                for (int i = x1; i <= x; i++) {
                    lijnen[y1+count][i]++;
                    count++;
                }
            }

        }
    }
    public static List<Vents> getVents() {
        return vents;
    }

    public static long getPoints(){
        long antwoord = 0;
        for (long[] longs : lijnen) {
            for (long aLong : longs) {
                if (aLong >= 2) {
                    antwoord++;
                }
            }
        }
        return antwoord;
    }

    public static void printMatrix() {
        long[][] arr = lijnen;
        int idx = -1;
        StringBuilder[] sbArr = new StringBuilder[arr.length];
        int counter=0;
        for (long[] row : arr) {
            sbArr[++idx] = new StringBuilder("(\t");

            for (long elem : row) {
                if (elem>=2)counter++;
                sbArr[idx].append(elem).append("\t");
            }
            sbArr[idx].append(")");
        }

        for (int i = 0; i < sbArr.length; i++) {
            System.out.println(sbArr[i]);
        }
        System.out.println("\nDONE\n" + " rows: " + counter);
        }
    @Override
    public String toString() {
        return "Vents : "+ x+ ","+ y + " -> "+ x1+ ","+ y1;
    }
}
