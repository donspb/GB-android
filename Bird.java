package Homework05;

public class Bird extends Animal {

    public Bird(String name) {

        super(name, 5, 0, 0.2f);

    }

    @Override
    String swim(int distance) {
        return "Птицы не умеют плавать, увы.";
    }
}
