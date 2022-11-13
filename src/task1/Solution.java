package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = createArray(n);
        List<String> list = printCycle(array, m);
        print(list);
    }

    private static int[] createArray(int n) {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
        }
        return ar;
    }

    private static List<String> printCycle(int[] array, int m) {
        int i = 0;
        List<String> integers = new ArrayList<>();

        do {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < m; j++) {
                if (i == array.length) {
                    i = 0;
                }
                temp.append(array[i]);
                i++;
            }
            i--;
            integers.add(temp.toString());
        } while (i != 0);

        return integers;
    }

    private static void print(List<String> list) {
        for (String s : list) {
            System.out.print(s.charAt(0));
        }
    }
}
