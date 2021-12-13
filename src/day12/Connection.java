package day12;

public class Connection {
    private final Cave cave1;
    private final Cave cave2;

    public Connection(Cave cave1, Cave cave2) {
        this.cave1 = cave1;
        this.cave2 = cave2;
        cave1.addConnectedCave(this);
        cave2.addConnectedCave(this);
    }

    public Cave getCave1() {
        return cave1;
    }

    public Cave getCave2() {
        return cave2;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "cave1=" + cave1.name +" "+ cave1.big+
                ", cave2=" + cave2.name +" "+ cave2.big+
                '}';
    }
}
