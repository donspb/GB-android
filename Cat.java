package Homework05;

public class Cat extends Animal {

    public Cat(String name) {

        super(name, 200, 0, 2.0f);

    }

    @Override
    String swim(int distance) {
        return "Коты не умеют плавать, увы.";
    }
}
