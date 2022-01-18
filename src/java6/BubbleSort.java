package java6;

import java.util.Arrays;

/**
 * @author 冯振卓
 * @ 2022/1/10 17:05
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int length = arr.length;
//        boolean sorted;
        for(int i=0;i<length-1;i++) { //循环次数  每完成一次  沉入底部一个数
//            sorted = true; //每一次开始  默认已经排好序
            for(int j=0;j<length-1-i;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
//                    sorted = false; //还没有排好序
                }
            }
//            if(sorted) { //确实已经排好序了
//                break; //不再继续循环
//            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

