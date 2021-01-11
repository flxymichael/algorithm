package sort;

/**
 * 基数排序
 * 由桶排序变化而来
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 设待排序列为n个记录，d个关键码，关键码的取值范围为radix
 * 时间复杂度为O(d(n+radix))，其中，一趟分配时间复杂度为O(n)，一趟收集时间复杂度为O(radix)，共进行d趟分配和收集。
 * 空间效率：需要2*radix个指向队列的辅助空间
 */
public class RadixSort {
    public static void sort(int[] array) {
        int maxBit=SortTest.getMaxBit(array);
        for (int i = 1; i <=maxBit; i++) {
            sortByBit(array,i);
        }
    }
    private static void sortByBit(int[] arr,int bit){
        int len = arr.length;
        int flag = 1;
        while (bit>1){
            flag*=10;
            bit--;
        }

        int[] outPut = new int[len];//存储"被排序数组"的临时数组
        int[] buckets = new int[10];

        //当前排序的位出现的次数
        for (int i = 0; i < len; i++) {

            //当前数取对应位之后的余数
            int currentBit = (arr[i]/flag)%10;
            buckets[currentBit]++;
        }

        //这么做的意思是，以i为余数及以比i小的数为余数的数共有buckets[i]个，
        //那么以i为余数的那个数在排序数组中对应的位置就是buckets[i]
        for (int i = 1; i <10; i++) {
            buckets[i]+=buckets[i-1];
        }


        for (int i = len-1; i >=0 ; i--) {
            int currentBit = (arr[i]/flag)%10;
            //以currentBit为余数的那个数，在排序数组optPut中的位置就是buckets[currentBit]-1
            outPut[buckets[currentBit]-1]=arr[i];
            //以currentBit为余数的数不止一个，处理一个数，少一个
            buckets[currentBit]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=outPut[i];
        }


    }

}
