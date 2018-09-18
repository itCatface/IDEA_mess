package util.lang;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Stack;

public class ArrayT {


    /*** check is object in the objects ***/
    public static int contains(Object[] objs, Object obj) {

        int e = -1;

        for (int i = 0; i < objs.length; i++) {

            if (!obj.equals(objs[i])) continue;

            else {
                e = i;
                break;
            }
        }

        return e;
    }


    /*** upside Down the objects ***/
    public static Object[] upsideDown(Object[] objs) {

        int length = objs.length;
        Object temp;

        for (int i = 0; i < length / 2; i++) {
            temp = objs[i];
            objs[i] = objs[length - 1 - i];
            objs[length - 1 - i] = temp;
        }

        return objs;
    }


    /*** sort int numbers ***/
    public static void sortChoose(int[] nums, boolean isAscend) {

        for (int i = 0; i < nums.length - 1; i++) {
            int center = nums[i];
            int min = 0;

            for (int j = i + 1; j <= nums.length - 1; j++) {

                boolean flag;

                if (isAscend) flag = center > nums[j];

                else flag = center < nums[j];

                if (flag) {
                    center = nums[j];
                    min = j;
                }
            }

            if (min != 0) {
                int f = nums[min];
                nums[min] = nums[i];
                nums[i] = f;
            }
        }
    }


    public static void sortInsert(int[] nums, boolean isAscend) {

        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int y = -1;

            for (int j = i - 1; j >= 0; j--) {
                boolean flag = true;

                if (isAscend) flag = t < nums[j];

                else flag = t > nums[j];

                if (!flag) break;

                nums[j + 1] = nums[j];
                y = j;
            }

            if (y > -1) nums[y] = t;
        }
    }


    public static void sortBubble(int[] nums, boolean isAscend) {

        for (int e = 0; e < nums.length - 1; e++) {
            for (int r = 0; r < nums.length - 1; r++) {
                boolean flag;

                if (isAscend) flag = nums[r] > nums[r + 1];

                else flag = nums[r] < nums[r + 1];
                
                if (flag) {
                    int t = nums[r];
                    nums[r] = nums[r + 1];
                    nums[r + 1] = t;
                }
            }
        }
    }


    public static void sortRecursion(int[] nums, int start, int end, boolean isAscend) {
        int tmp = nums[start];
        int i = start;

        if (isAscend) {

            for (int j = end; i < j; ) {

                while (nums[j] > tmp && i < j) j--;

                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                for (; nums[i] < tmp && i < j; i++) ;
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }

        } else {
            for (int j = end; i < j; ) {

                while (nums[j] < tmp && i < j) j--;

                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                for (; nums[i] > tmp && i < j; i++) ;

                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
        }

        nums[i] = tmp;
        if (start < i - 1) sortRecursion(nums, start, i - 1, isAscend);
        if (end > i + 1) sortRecursion(nums, i + 1, end, isAscend);
    }


    public static void sortStack(int[] nums, boolean isAscend) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(nums.length - 1);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            int i = start;
            int j = end;
            int tmp = nums[i];

            if (isAscend) {
                while (i < j) {
                    while (nums[j] > tmp && i < j)
                        j--;

                    if (i < j) {
                        nums[i] = nums[j];
                        i++;
                    }

                    for (; nums[i] < tmp && i < j; i++) ;

                    if (i < j) {
                        nums[j] = nums[i];
                        j--;
                    }
                }

            } else {
                while (i < j) {
                    while (nums[j] < tmp && i < j)
                        j--;

                    if (i < j) {
                        nums[i] = nums[j];
                        i++;
                    }

                    for (; nums[i] > tmp && i < j; i++) ;

                    if (i < j) {
                        nums[j] = nums[i];
                        j--;
                    }
                }
            }

            nums[i] = tmp;
            if (start < i - 1) {
                stack.push(start);
                stack.push(i - 1);
            }

            if (end > i + 1) {
                stack.push(i + 1);
                stack.push(end);
            }
        }
    }
}
