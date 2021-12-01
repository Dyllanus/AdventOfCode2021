package AdventOfCode2020.day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day2Opdr2 {
    public static void main(String[] args) {
        int valid = 0;
        int laagCijfer, hoogCijfer = 0;
        char letter;
        try {
            BufferedReader reader =  new BufferedReader(new FileReader("src/AdventOfCode2020/day2/input.txt"));
            String line = reader.readLine();
            while(line !=null){
                String[] splitst = line.split(": ");
                String password = splitst[1];
                splitst = splitst[0].split(" ");

                letter = splitst[1].charAt(0);

                laagCijfer = Integer.parseInt(splitst[0].split("-")[0]);
                hoogCijfer = Integer.parseInt(splitst[0].split("-")[1]);
                if (password.charAt(laagCijfer-1)==letter){
                    if (!(password.charAt(hoogCijfer-1)==letter)){
                        valid++;
                    }
                }else if ((password.charAt(hoogCijfer-1)==letter)){
                    if (!(password.charAt(laagCijfer-1)==letter)){
                        valid++;
                    }
                }

                line = reader.readLine();
            }
            System.out.println(valid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
