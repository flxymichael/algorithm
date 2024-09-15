package sort;

import java.util.Arrays;

public class RadixSort implements Sort{
    @Override
    public void sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max/exp>0; exp*=10) {
            countSort(arr,exp);
        }
    }

    private void countSort(int[] arr,int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count,0);

        //计算每个桶的大小
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i]/exp)%10;
            count[index]++;
        }

        //
    }
}
