package algorithm.sort;

import java.util.Random;
import java.util.function.Function;

public class SortTest {
    public static void main(String[] args) {
        //int[] arr = initArray(10);
        int[] arr= {5,9,3,6,6,7,1,2,3,0};
        System.out.println(arr.length);
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println("");
        RadixSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + ",");
        }
    }

    public static void exchange(int[] arr, int j, int k) {
        arr[j] = arr[j] + arr[k];
        arr[k] = arr[j] - arr[k];
        arr[j] = arr[j] - arr[k];
    }

    public static int[] initArray(int bound) {
        Function<Integer, int[]> getRandom = (max) -> {
            Random random = new Random();
            int[] arr = new int[max];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = random.nextInt(max);
            }
            return arr;
        };
        return getRandom.apply(bound);
    }
    public static int getMaxBit(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max)max=arr[i];
        }
        return String.valueOf(max).length();
    }
}
