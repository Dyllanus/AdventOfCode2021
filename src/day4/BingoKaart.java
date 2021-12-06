package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoKaart {
    private final int[][] kaart;
    private static List<BingoKaart> alleKaarten = new ArrayList<>();
    private boolean[][] matrixGetal = new boolean[5][5];
    private boolean BINGO = false;

    public BingoKaart(int[][] kaart){
        this.kaart = kaart;
        alleKaarten.add(this);
    }

    public static long spelen(List<Integer> ints){
        List<BingoKaart> bongo = new ArrayList<>(alleKaarten);
        int counter=0;
        for (int i:ints){
            for (BingoKaart kaart: alleKaarten){
                int[][] getallen = kaart.getKaart();
                boolean[][] bool = kaart.getMatrixGetal();

                for (int y=0; y<5; y++){
                    for (int j=0; j<5;j++){
                        if (getallen[y][j]==i){
                            bool[y][j]=true;
                        }
                    }
                }

                if (bongo.size()==1){
                    if (bingo(bongo.get(0))) {
                        System.out.println("counter" + counter);
                        System.out.println();
                        printMatrix(bongo.get(0));
                        System.out.println();
                        printMatrix(kaart);
                        System.out.println(i);
                        return calculateWinner(kaart) * i;
                    }
                } else if (bingo(kaart)) {
                    bongo.remove(kaart);
                }
            }
            counter++;
        }
        return 0;
    }

    private static boolean bingo(BingoKaart kaart){
        boolean[][] matrixGetal = kaart.getMatrixGetal();
        //check left -> right
        for (int i=0; i<5; i++) {
            for (int j = 0; j < 5-4; j++) {
                if (matrixGetal[i][j] && matrixGetal[i][j +1] && matrixGetal[i][j +2] && matrixGetal[i][j +3] && matrixGetal[i][j +4]) {
                    kaart.setBINGO(true);
                    return true;
                }
            }
        }
        //check up -> down
        for (int i=0; i<5-4; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrixGetal[i][j] && matrixGetal[i+1][j] && matrixGetal[i+2][j] && matrixGetal[i+3][j] && matrixGetal[i+4][j]) {
                    kaart.setBINGO(true);
                    return true;
                }
            }
        }
        return false;
    }

    private static long calculateWinner(BingoKaart kaart){
        long sum= 0L;
        int[][] getallen = kaart.getKaart();
        boolean[][] bool = kaart.getMatrixGetal();
        for (int y=0; y<5; y++){
            for (int j=0; j<5;j++){
                if (!bool[y][j]){
                    sum+=getallen[y][j];
                }
            }
        }
        return sum;
    }

    public void setBINGO(boolean BINGO) {
        this.BINGO = BINGO;
    }

    public static List<BingoKaart> getAlleKaarten() {
        return alleKaarten;
    }

    public int[][] getKaart() {
        return kaart;
    }

    public boolean[][] getMatrixGetal() {
        return matrixGetal;
    }

    public boolean isBINGO() {
        return BINGO;
    }

    private static void printMatrix(BingoKaart kaart){
        int[][] f = kaart.getKaart();
        for (int y=0; y<5; y++){
            for (int j=0; j<5;j++){
                System.out.print(f[y][j]+ " ");
            }
            System.out.println();
        }
        boolean[][] x = kaart.getMatrixGetal();
        for (int y=0; y<5; y++){
            for (int j=0; j<5;j++){
                System.out.print(x[y][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
