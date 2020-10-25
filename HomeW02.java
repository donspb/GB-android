import java.util.Arrays;

public class HomeW02 {

    public static void main(String[] args) {

        int[] binarArray = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] emptyArray = new int[8];
        int[] anotherArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[] testArray = { 1, 1, 1, 2, 1, 1 };
        int[] someArray= { 1, 2, 3, 4, 5 };
        int r = -2;

        System.out.println(Arrays.toString(firstInvertor(binarArray)));
        System.out.println(Arrays.toString(secondFiller(emptyArray)));
        System.out.println(Arrays.toString(thirdMultiplier(anotherArray)));

        fourthMinMax(anotherArray);
        fifthDiags(5,5);

        System.out.println(sixthBalance(testArray));
        System.out.println(Arrays.toString(seventhRotator(someArray, r)));

    }

    public static int[] firstInvertor(int[] arrToInv) {             // Задание 1. Инверсия массива

        for (int i = 0; i < arrToInv.length ; i++) arrToInv[i] = 1 - arrToInv[i];
        return arrToInv;

    }

    public static int[] secondFiller(int[] arrToFill) {             // Задание 2. Заполнение массива

        for (int i = 1, j = 0; i <= 22; i += 3, j++) arrToFill[j] = i;
        return arrToFill;

    }

    public static int[] thirdMultiplier(int[] arrToMult) {          // Задание 3. Умножение элементов

        for (int i = 0; i < arrToMult.length ; i++)  if (arrToMult[i] < 6) arrToMult[i] *= 2;
        return arrToMult;

    }

    public static void fourthMinMax(int[] arrForSearch) {           // Задание 4. Минимум и максимум

        int min = arrForSearch[0];
        int max = arrForSearch[0];

        for (int i = 1; i < arrForSearch.length; i++) {
            if (arrForSearch[i] < min) min = arrForSearch[i];
            if (arrForSearch[i] > max) max = arrForSearch[i];
        }

        System.out.println("Элемент-максимум: " + max);
        System.out.println("Элемент-минимум: " + min);

    }

    public static void fifthDiags(int x, int y) {           // Задание 5. Заполнение диагоналей

        int[][] arrToProcess = new int[x][y];
        for (int i = 0; i < arrToProcess.length; i++) {
            arrToProcess[i][i] = 1;
            arrToProcess[i][arrToProcess[i].length - 1 - i] = 1;
            System.out.println(Arrays.toString(arrToProcess[i]));
        }

    }

    public static boolean sixthBalance(int[] arrToCheck) {          // Задание 6. Проверка баланса

        for (int i = 0; i < arrToCheck.length ; i++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 0; j <= i; j++) sumLeft += arrToCheck[j];
            for (int k = arrToCheck.length-1; k > i; k--) sumRight += arrToCheck[k];

            if (sumLeft == sumRight) return true;
        }

        return false;
    }

    public static int[] seventhRotator(int[] arrToRotate, int x) {      // Задания 7 и 8. Смещение элементов массива

        int temp, start, end, step, inc;

        if (x >= 0) {
            start = arrToRotate.length - 1;
            end = 0;
            step = -1;
        }
        else {
            start = 0;
            end = arrToRotate.length - 1;
            step = 1;
            x *= -1;
        }

        for (int i = 0; i < x; i++) {
            temp = arrToRotate[start];
            inc = start;

            while (true) {
                arrToRotate[inc] = arrToRotate[inc + step];
                inc += step;
                if (inc == end) break;
            }

            arrToRotate[end] = temp;
        }

        return arrToRotate;
    }

}
