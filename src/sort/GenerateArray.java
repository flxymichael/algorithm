package sort;

import java.util.Random;

public class GenerateArray {
    public int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] =random.nextInt(n*10);
        }
        return arr;
    }
}
