package demo;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class SortDemo {
    public static void main(String[] args) {
        sort("排序前");

//        choose();

//        selectSort();
//        bubble();
        insert();

        sort("排序后");
    }

    //    static int[] nums = {3, 7, 2, 9, 6, 1, 8, 0, 4, 5};
//    static int[] nums = {5, 7, 9, 2, 6, 3, 1, 4, 8};
//    static int[] nums = {5, 2, 8, 4, 9, 1};


    /* 冒泡排序 */
    static int[] nums = {3, 6, 5, 7, 8, 1};

    static void bubble() {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


    /* 插入排序 */
    static void insert() {
        int temp, j;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }


    static void choose() {
        for (int i = 0; i < nums.length - 1; i++) {
            int position = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[position] > nums[j]) {
                    position = j;
                }
            }

            if (position != i) {
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
            }
            sort("第" + i++ + "次外层循环结果");
            System.out.println();
        }
    }

    /**
     * 简单选择排序
     */
    static void selectSort() {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
            sort("第" + i++ + "次外层循环结果");
            System.out.println();
        }
    }


    static void sort(String msg) {
        String result = "";
        for (int i : nums) {
            result += (i + " -- ");
        }
        System.out.println(msg + "-->" + result.substring(0, result.lastIndexOf(" -- ")));
    }
}
