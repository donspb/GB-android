package Homework05;

public class Horse extends Animal {

    public Horse(String name) {
        super(name, 1500, 100, 3.0f);
    }

    public Horse(String name, int runLimit, int swimLimit, float jumpLimit) {
        super(name, runLimit, swimLimit, jumpLimit);
    }
}
