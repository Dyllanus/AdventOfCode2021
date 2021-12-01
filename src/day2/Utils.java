package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> readFileToIntegers(String path){
        try {
            List<Integer> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line !=null){
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<String> readFileToStrings(String path){
        try {
            List<String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line !=null){
                list.add(line);
                line = reader.readLine();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

