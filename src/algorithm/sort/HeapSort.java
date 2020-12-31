package algorithm.sort;

import algorithm.Heap.MaxPQ;

/**
 * 堆排序
 * 构建最大堆
 * 取堆顶元素，与末尾元素交换，重新构建最大堆（堆尾元素除外）
 * 时间复杂度nlog(n)
 */
public class HeapSort {
    public static void sort(int[] array) {
        int N = array.length-1;
        for (int i = (array.length/2)-1; i>=0; i--) {//todo 为什么=0也行,,因为：先用再减！
            sink(array,i, N);
        }
        for (int i :array
             ) {
            System.out.print(i+",");
        }
        System.out.println();
        while (N>0){
            SortTest.exchange(array,0,N--);
            sink(array,0,N);
        }
    }
    private static void sink(int[] arr,int k,int length){
        //在使用数组的第一个位置的情况下， 节点i的左子树为2*i+1，右子树为2*i+2
        //在不使用数组的第一个位置的情况下,节点i的左子树为2*i，右子树为2*i+1
        while ((k*2+1)<length){
            int j = k*2+1;
            if (j<length&&arr[j]<arr[j+1])j++;
            if (arr[j]<arr[k])break;
            SortTest.exchange(arr,j,k);
            k=j;
        }
    }
}
