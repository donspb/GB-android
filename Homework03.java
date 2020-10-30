import java.util.Random;
import java.util.Scanner;

public class Homework03 {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int SIZEX = 5;
    public static final int SIZEY = 5;
    public static final int WINSER = 4;
    public static final char EMPTYCELL = '_';
    public static final char HUMANMARK = 'X';
    public static final char PCMARK = 'O';
    public static final Random RANDOM = new Random();

    public static char[][] field = new char[SIZEY][SIZEX];

    public static void fillEmpty() {                                    // Начальное заполнение пустого поля
        for (int i = 0; i < SIZEY ; i++)
            for (int j = 0; j < SIZEX; j++) field[i][j] = EMPTYCELL;
    }

    public static void printField() {                                   // Вывод поля
        for (int i = 0; i < SIZEY ; i++) {
            for (int j = 0; j < SIZEX; j++) System.out.print(" | " + field[i][j]);
            System.out.println(" |");
        }
    }

    public static boolean isValidInput(int x, int y) {                  // Проверка правильности ввода координат

        return x >= 0 && x < SIZEX && y >= 0 && y < SIZEY;

    }

    public static boolean isEmptyCell(int x, int y) {                   // Проверка пустоты ячейки

        return field[y][x] == EMPTYCELL;
    }

    public static void humanTurn() {                                    // Ход пользователя, ввод координат

        int x, y;

        do {
            System.out.println("Введите координаты в формате 'строка столбец' (от 1 до 5, через пробел):");
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;
        } while (!isValidInput(x, y) || !isEmptyCell(x, y));

        field[y][x] = HUMANMARK;
    }

    public static boolean isFieldFull() {                               // Проверка заполненности поля

        for (int i = 0; i < SIZEY; i++)
            for (int j = 0; j < SIZEX; j++) if (field[i][j] == EMPTYCELL) return false;

        return true;

    }

    public static int countSer(int y, int x, char c, int direction) {   // Подсчет длины серии одинаковых знаков

        int sum = 1;
        int a, b;

        switch (direction) {                                                        // direction - направление счёта
            case 0:                                                                 // 0 - вниз по столбцу
                for (a = y + 1; a < SIZEY; a++) {
                    if (field[a][x] == c) sum++;
                    else break;
                }
                break;

             case 1:                                                                // 1 - вправо по строке
                 for (a = x + 1; a < SIZEX; a++) {
                     if (field[y][a] == c) sum++;
                     else break;
                 }
                 break;

            case 2:                                                                // 2 - диагональ вправо
                for (a = y + 1, b = x + 1; a < SIZEY && b < SIZEX; a++, b++) {
                    if (field[a][b] == c) sum++;
                    else break;
                }
                break;

            case 3:                                                                 // 3 - диагональ влево
                for (a = y + 1, b = x - 1; a < SIZEY && b >= 0; a++, b--) {
                    if (field[a][b] == c) sum++;
                    else break;
                }
                break;
        }

        return sum;

    }

    public static boolean makePCTurn(int begi, int begj, int len, int dir) {            // Блокирование цепочек
                                                                                        // из пользовтельских значков
        switch (dir) {                                                                  // длиной 3 или 2 символа

            case 0:
                if (begi - 1 >= 0 && isEmptyCell(begj, begi - 1)) {
                    field[begi - 1][begj] = PCMARK;
                    return true;
                }
                else if (begi + len < SIZEY && isEmptyCell(begj, begi + len)) {
                    field[begi + len][begj] = PCMARK;
                    return true;
                }
                break;

            case 1:
                if (begj - 1 >= 0 && isEmptyCell(begj - 1, begi)) {
                    field[begi][begj - 1] = PCMARK;
                    return true;
                }
                else if (begj + len < SIZEX && isEmptyCell(begj + len, begi)) {
                    field[begi][begj + len] = PCMARK;
                    return true;
                }
                break;

            case 2:
                if (begi - 1 >= 0 && begj - 1 >= 0 && isEmptyCell(begj - 1, begi - 1)) {
                    field[begi - 1][begj - 1] = PCMARK;
                    return true;
                }
                else if (begi + len < SIZEY && begj + len < SIZEX && isEmptyCell(begj + len, begi + len)) {
                    field[begi + len][begj + len] = PCMARK;
                    return true;
                }
                break;

            case 3:
                if (begi - 1 >= 0 && begj + 1 < SIZEX && isEmptyCell(begj + 1, begi - 1)) {
                    field[begi - 1][begj + 1] = PCMARK;
                    return true;
                }
                else if (begi + len < SIZEY && begj - len >= 0 && isEmptyCell(begj - len, begi + len)) {
                    field[begi + len][begj - len] = PCMARK;
                    return true;
                }
                break;
        }

        return false;

    }

    public static boolean analyzer() {                     // Поиск последовтельностей из значков пользователя

        int res;

        for (int tryLen = 3; tryLen > 1; tryLen--) {
            for (int i = 0; i < SIZEY; i++)
                for (int j = 0; j < SIZEX; j++)
                    if (field[i][j] == HUMANMARK)
                        for (int k = 0; k <= 3; k++) {
                            res = countSer(i, j, HUMANMARK, k);
                            if (res >= tryLen && makePCTurn(i, j, res, k)) return true;
                        }
        }

        return false;

    }

    public static boolean checkWin(char c) {                    // Проверка на победу

        for (int i = 0; i < SIZEY; i++)
            for (int j = 0; j < SIZEX; j++)
                if (field[i][j] == c)
                    for (int k = 0; k <= 3; k++) if (countSer(i, j, c, k) >= WINSER) return true;

        return false;
    }

    public static void pcTurn() {                   // Ход компьютера. Если у пользователя есть последовательности из
                                                    // двух и более символов - блокировать, иначе - рандомный ход.
        int x, y;

        if (!analyzer()) {
            do {
                x = RANDOM.nextInt(SIZEX);
                y = RANDOM.nextInt(SIZEY);
            } while (!isEmptyCell(x, y));

            field[y][x] = PCMARK;
        }

    }

    public static void main(String[] args) {

        fillEmpty();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(HUMANMARK)) {
                System.out.println("Пользователь победил!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }

            pcTurn();
            System.out.println("Ход компьютера:");
            printField();

            if (checkWin(PCMARK)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }

    }
}
