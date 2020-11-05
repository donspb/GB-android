package Homework05;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 10, 0.5f);
    }

    public Dog(String name, int runLimit, int swimLimit, float jumpLimit) {
        super(name, runLimit, swimLimit, jumpLimit);
    }
}
