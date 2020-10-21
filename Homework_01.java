
package Homework_01;

public class Main {

    public static void main(String[] args) {            // Задание 1. Создать 

        byte byteSample = 120;                          //
        short shortSample = 10000;                      //
        int intSample = 123456790;                      //
        long longSample = 496000489392L;                //
                                                        //
        float floatSample = 36.6f;                      // Задание 2. Данные
        double doubleSample = -70.01d;                  //
                                                        //
        char charSample = 'X';                          //
        String stringSample = "String Sample";          //
                                                        //
        boolean boolSample = true;                      //

        System.out.println(thirdPoint(5,6,7,2));

        System.out.println(fourthPoint(5,5));

        fifthPoint(492);

        sixthPoint(2020);

    }

    public static int thirdPoint(int a, int b, int c, int d) {   // Задание 3. Вычисление выражения

        return a*(b+(c/d));

    }

    public static boolean fourthPoint(int a, int b) {             // Задание 4. Проверка суммы чисел на попадание в диапазон

        return ((a + b) >= 10) && ((a + b) <= 20);

    }

    public static void fifthPoint(int a) {                        // Задание 5. Число наоборот

        if (a > 100 && a <= 999) {
            System.out.print((a%100)%10);
            System.out.print((a%100)/10);
            System.out.println(a/100);
        }
    }

    public static void sixthPoint(int year) {              // Задание 6. Високосный год

        if ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))) System.out.println( year + " ãîä - íå âèñîêîñíûé");
        else System.out.println(year + " ãîä - âèñîêîñíûé");
    }
}
