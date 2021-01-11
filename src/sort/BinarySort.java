package sort;

public class BinarySort {
    public static void sort(int[] array) {
        divide(array, 0, array.length - 1);
    }

    public static void divide(int[] array, int start, int end) {

        if (start >= end) return;
        int mid = start+((end-start)>>1);
        divide(array, start, mid);
        divide(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {

        int length = (end - start) + 1;
        int[] tmp = new int[length];
        int p = 0;
        int p1 = start;
        int p2 = mid + 1;
        // TODO: 2020/12/30 为啥p2可以=end
        //解决了，，p2++，先用再加，不会溢出的
        //否则，娶不到array[end]
        while (p1 <=mid && p2 <=end) {
            if (array[p1] <array[p2]) {
                tmp[p++] = array[p1++];
            } else {
                tmp[p++] = array[p2++];
            }
        }
        // TODO: 2020/12/30 为啥p1可以=mid，p2可以=end
        // 同上
        while (p1<=mid){
            tmp[p++] = array[p1++];
        }
        while (p2<=end){
            tmp[p++] = array[p2++];
        }

        for (int i = 0; i <tmp.length; i++) {
            array[start+i]=tmp[i];
        }
    }
}
