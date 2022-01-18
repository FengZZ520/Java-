package java6;

/**
 * @author 冯振卓
 * @ 2022/1/10 17:21
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {1,5,2,8,7,3,5,6,1,9};
        for (int num : arr){
            System.out.print(num + " ");
        }
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println();
        for (int num : arr){
            System.out.print(num + " ");
        }

    }
}
