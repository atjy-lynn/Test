package pers.li.test.sort;

import java.util.Arrays;

public class Sort {
    // 需排序的数组
    private static int[] ARRAY = {49, 38, 65, 97, 76, 13, 27, 49};
    // result type
    private final static ResultType ORIGINAL = ResultType.ORIGINAL;
    private final static ResultType IN_SORT = ResultType.IN_SORT;
    private final static ResultType FINAL = ResultType.FINAL;
    // title type
    private final static SortType SELECT = SortType.SELECT_SORT;
    private final static SortType INSERT = SortType.INSERT_SORT;
    /**
     *排序类别；（由于用枚举太麻烦，用字符有些区分麻烦，所以这用int）
     * @menu
     * 0 --> 选择排序
     * 1 --> 插入排序
     */
    private final static int SORT_TYPE = 0;

    public static void main(String[] args) {
        switch (SORT_TYPE) {
            case 0:// 0 --> 选择排序
                showSort(SELECT);
                break;

            case 1:// 1 --> 插入排序
                showSort(INSERT);
                break;

            default:
                throw new RuntimeException("错误排序算法选项！");
        }

    }

    // 排序算法

    /**
     * 选择排序
     * @param arr
     * @return
     */
    private static int[] selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;// 定义一个变量用于保存最小/大值下标
            // 遍历数组找出最小值
            for (int j = i; j < length; j++) {
                // 如若当前下标j为最小/大值，则将j的下标赋值给index
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            //如若不想定义三房变量实现换位则可使用以下代码：
			/*
			arr[index] += arr[i];
			arr[i] = arr[index] - arr[i];
			arr[index] = arr[index] - arr[i];
			*/

            printArrayResult(IN_SORT, arr);
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    private static int[] insertSort(int[] arr) {
        int temp;
        int j;

        return arr;
    }

    // show
    private static void showSort(SortType type) {
        switch (type) {
            case SELECT_SORT:
                printTitle(SELECT);
                printArrayResult(ORIGINAL, ARRAY);
                printArrayResult(FINAL, selectSort(ARRAY));
                break;

            case INSERT_SORT:

            default:
                throw new RuntimeException("错误排序算法选项！");
        }
    }

    // print

    /**
     * 输出打印排序标题
     * @param type
     */
    private static void printTitle(SortType type) {
        final String prefix = "--------------------- ";
        final String suffix = " ---------------------";

        switch (type) {
            case SELECT_SORT:
                System.out.println(prefix + "select sort" + suffix);
                break;

            default:
                throw new RuntimeException("错误的标题类型选项！");
        }
    }

    /**
     * 输出打印数组结果
     * @param type 0 为原始数组（未经过排序）；
     *             1 为最终结果（经过排序）；
     * @param array 展示的数组
     */
    private static void printArrayResult(ResultType type ,int[] array) {
        final String originalArrayTitle =
                "Original array: ";
        final String finalResultArrayTitle =
                "Final result: ";
        final String noneArrayTitle = "In sort: ";
        
        switch (type) {
            case ORIGINAL:
                System.out.println(originalArrayTitle + arrayToString(array));
                break;

            case IN_SORT:
                System.out.printf("%s", noneArrayTitle);
                System.out.println(arrayToString(array));
                break;

            case FINAL:
                System.out.println(finalResultArrayTitle + arrayToString(array));
                break;

            default:
                throw new RuntimeException("错误的结果类型选项！");
        }
    }

    // toString
    /**
     * 获取转换成字符串的数组类型
     * @param arr 需要转换的数组
     * @return 返回转换为字符串的数组
     */
    private static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    // enum

    public enum ResultType{
        ORIGINAL, FINAL, IN_SORT
    }

    public enum SortType{
        SELECT_SORT, INSERT_SORT
    }
}
