package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cave {
    String name;
    boolean big;
    List<Connection> connectedCaves =new ArrayList<>();
    static List<Cave> allCaves = new ArrayList<>();

    public Cave(String name, boolean big) {
        this.name = name;
        this.big = big;
        if (!allCaves.contains(this)){
            allCaves.add(this);
        }

    }

    public void addConnectedCave(Connection con){
        connectedCaves.add(con);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(name, cave.name);
    }

    @Override
    public String toString() {
        return "Cave{" +
                "name='" + name + '\'' +
                ", big=" + big + connectedCaves;
    }
}
