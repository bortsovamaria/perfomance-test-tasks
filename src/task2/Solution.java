package task2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        Scanner scannerFileFirst = new Scanner(fr);
        int x = scannerFileFirst.nextInt();
        int y = scannerFileFirst.nextInt();
        int radius = scannerFileFirst.nextInt();
        fr.close();

        FileReader fr2 = new FileReader(args[1]);
        Scanner scannerFileSecond = new Scanner(fr2);

        while (scannerFileSecond.hasNextInt()) {
            int a = scannerFileSecond.nextInt();
            int b = scannerFileSecond.nextInt();
            if (formula(x, y, a, b) < radius) {
                System.out.println(1);
            } else if (formula(x, y, a, b) > radius) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }

        fr2.close();
    }

    // (x - a) + (y - b) < r^2 - в окружности
    // (x - a) + (y - b) = r^2 - на окружности
    // (x - a) + (y - b) >= r^2 - снаружи окружности
    static double formula(int x, int y, int a, int b) {
        return Math.pow((x - a), 2) + Math.pow((y - b), 2);
    }

}
