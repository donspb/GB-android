package Homework05;

public class Animal {

    protected int runLimit;
    protected int swimLimit;
    protected float jumpLimit;
    protected String name;

    public Animal(String name, int runLimit, int swimLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

    String run(int distance) {
        if (distance <= runLimit) return name + " пробежал " + distance + " м";
        else return name + " не смог столько пробежать.";
    }

    String swim(int distance) {
        if (distance <= swimLimit) return name + " проплыл " + distance + " м";
        else return name + " не смог столько проплыть.";
    }

    String jump(int height) {
        if (height <= runLimit) return name + " подпрыгнул на " + height + " м";
        else return name + "не смог так высоко прыгнуть.";
    }
}
