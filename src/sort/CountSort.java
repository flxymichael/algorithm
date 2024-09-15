package sort;

public class CountSort implements Sort{
    @Override
    public void sort(int[] arr) {
       int min =getMin(arr);
       int max = getMax(arr);

        //让min在计数数组中的位置从0开始，可以省min个位置
        int range = max+1-min;
        int[] count = new int[range];

        //填充计数数组
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-min]++;
        }


        //累加技术数组，以便找到每个元素在排序后数组中出现的最后一个位置
        for (int i = 1; i <count.length ; i++) {
            count[i]+=count[i-1];
        }

        // 从后向前遍历原数组，确保稳定性
        int[] output = new int[arr.length];


        for (int i = arr.length - 1; i >= 0; i--) {
            int a= arr[i]-min;//arr[i]在count数组中的位置,由于count已被累加处理过，所以count[a]不在表示元素出现的次数，而是每个元素在排序后数组中出现的最后一个位置
            int b =count[a]-1;//最后出现的位置-1即为在排序后数组output中出现的位置
            output[b] = arr[i];
            count[a]--;
        }

        // 将排序后的数组复制回原数组
        System.arraycopy(output, 0, arr, 0, arr.length);

    }
}
