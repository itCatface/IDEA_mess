package util.lang.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class IntT {


    public static List<Integer> random(int length, int max, boolean repeat) {
        List<Integer> nums = new ArrayList<>();
        int num;

        Random random = new Random();

        int i = 0;

        while (i < length) {
            num = random.nextInt(max);

            if (repeat) {
                nums.add(num);

                i++;
            } else {
                if (!nums.contains(num)) {
                    nums.add(num);
                    i++;
                }
            }
        }

        return nums;
    }
}