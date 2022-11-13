package task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader(args[0]);
        Scanner scanner = new Scanner(fr);

        List<Integer> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            int i = Integer.parseInt(s);
            list.add(i);
        }

        int avg = getAvg(list);
        int result = 0;

        while (!isSameIntegers(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == avg) {
                    continue;
                }
                if (list.get(i) < avg) {
                    Integer cur = list.get(i);
                    list.remove(i);
                    list.add(i, cur + 1);
                    result++;
                }
                if (list.get(i) > avg) {
                    Integer cur = list.get(i);
                    list.remove(i);
                    list.add(i, cur - 1);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isSameIntegers(List<Integer> list) {
        boolean result = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (!list.get(i).equals(list.get(i + 1))) {
                result = false;
            }
        }
        return result;
    }

    static int getAvg(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result / list.size();
    }
}
