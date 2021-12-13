package day12;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Klok {

    public void run(String path){
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            for (String s :strings){
                String[] split=  s.split("-");
                Cave c = new Cave(split[0],split[0].equals(split[0].toUpperCase()));
                Cave c1 = new Cave(split[1],split[1].equals(split[1].toUpperCase()));
                new Connection(c, c1);
            }
            System.out.println(Cave.allCaves.get(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Klok jobo = new Klok();
        jobo.run("src/day12/example.txt");
    }
}
