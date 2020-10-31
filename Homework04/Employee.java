package Homework04;

public class Employee {

    private String surNamePatron;
    private String position;
    private int phoneNumber;
    private int salary;
    private int age;
    private int personalID;
    static int id = 1;

    Employee(String snp, String pos, int phone, int sal, int age) {
        this.surNamePatron = snp;
        this.position = pos;
        this.phoneNumber = phone;
        this. salary = sal;
        this.age = age;
        this.personalID = id;

        id++;
    }

    public String getSurNamePatron() {
        return surNamePatron;
    }

    public String getPosition() {
        return position;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return personalID;
    }

    public void setSalary(int bonus) {
        this.salary = bonus;
    }
}
