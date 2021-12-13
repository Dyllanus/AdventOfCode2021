package day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Jovo {
    public void run(String path) throws IOException {
        List<String> lines = Files.lines(Paths.get(path)).collect(Collectors.toList());
        List<Character> foutieveLijst = new ArrayList<>();
        List<List<Character>> antwoorden = new ArrayList<>();
        for (String line : lines){
            List<Character> opening = new ArrayList<>();
            List<Character> sluiting = new ArrayList<>();
            for (char c : line.toCharArray()) {
                boolean sluitChar = false;
                switch (c) {
                    case '>' -> {
                        sluitChar = true;
                        sluiting.add('<');
                    }
                    case '}' -> {
                        sluitChar = true;
                        sluiting.add('{');
                    }
                    case ']' -> {
                        sluitChar = true;
                        sluiting.add('[');
                    }
                    case ')' ->{
                        sluitChar = true;
                        sluiting.add('(');
                    }
                    case '<', '{', '[', '(' -> opening.add(c);
                }
                if (sluitChar) {
                    if (opening.get(opening.size() - 1) != sluiting.get(sluiting.size() - 1)) {
                        foutieveLijst.add(c);
                        opening = new ArrayList<>();
                        break;
                    }else if (opening.get(opening.size() - 1) == sluiting.get(sluiting.size() - 1)){
                        opening.remove(opening.size() - 1);
                        sluiting.remove(sluiting.size() - 1);
                    }
                }
            }
            if (!opening.isEmpty()) {
                antwoorden.add(opening);
            }
        }
        Collections.sort(foutieveLijst);
        int haakje = 0;
        int blokhaakje = 0;
        int accolade = 0;
        int kleiner = 0;
        for (char c: foutieveLijst){
            switch (c) {
                case ')' -> haakje++;
                case ']' -> blokhaakje++;
                case '}' -> accolade++;
                case '>' -> kleiner++;
            }
        }
        System.out.println(haakje * 3 + blokhaakje * 57 + accolade * 1197 +  kleiner * 25137);
        List<Long> woord = new ArrayList<>();
        for (List<Character> lijst: antwoorden){
            long ros = 0;
            Collections.reverse(lijst);
            for (char c: lijst){
                ros *=5;
                switch (c){
                    case '(' -> ros+=1;
                    case '[' -> ros+=2;
                    case '{' -> ros+=3;
                    case '<' -> ros+=4;
                }
            }
            woord.add(ros);
        }
        Collections.sort(woord);
        System.out.println(woord.get(woord.size()/2));
    }

    public static void main(String[] args) {
        Jovo jovo= new Jovo();
        try {
            jovo.run("src/day10/input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
