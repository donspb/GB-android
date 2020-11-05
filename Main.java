package Homework05;

public class Main {

    public static void main (String args[]) {
        Dog dog = new Dog("Собака");
        Horse horse = new Horse("Лошадь");
        Bird bird = new Bird("Курица");
        Cat cat = new Cat("Кот");
        Dog superdog = new Dog("СуперПёс", 1500, 500, 10);


        System.out.println(cat.run(150));
        System.out.println(dog.swim(150));
        System.out.println(superdog.swim(150));
        System.out.println(horse.jump(1));
        System.out.println(bird.swim(10));

    }


}
