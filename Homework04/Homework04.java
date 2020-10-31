package Homework04;

public class Homework04 {

    public static void main(String[] args) {

        Employee[] employeesList = new Employee[5];

        employeesList[0] = new Employee("Иванов Егор Андреевич", "директор", 1010, 500000, 57);
        employeesList[1] = new Employee("Филькенштейн Абрам Иосифович", "бухгалтер", 2020, 499999, 40);
        employeesList[2] = new Employee("Семенова Агнесса Витальевна", "уборщица", 9999, 15000, 84);
        employeesList[3] = new Employee("Андреева Ольга Львовна", "менеджер", 0777, 40000, 22);
        employeesList[4] = new Employee("Петров Николай Сергеевич", "сантехник", 6660, 30000, 38);

        System.out.println(employeesList[0].getSurNamePatron() + " занимает должность " + employeesList[0].getPosition());
        System.out.println();

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < employeesList.length; i++)
            if (employeesList[i].getAge() >= 40) System.out.println(employeesList[i].getSurNamePatron());

        employeesList = addBonus(employeesList);
        System.out.println();

        for (int i = 0; i < employeesList.length; i++) System.out.println(employeesList[i].getId() + ". " + employeesList[i].getSurNamePatron() + " " + employeesList[i].getSalary());

    }

    public static Employee[] addBonus(Employee[] employeesArray) {

        for (int i = 0; i < employeesArray.length; i++)
            if (employeesArray[i].getAge() >= 45) employeesArray[i].setSalary(employeesArray[i].getSalary() + 5000);

        return employeesArray;
    }

}
