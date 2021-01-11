package sort;

/**
 * 选择排序
 * 比较1和2，1和3，1和4。。。
 *    2和3，2和4，2和5。。。
 * 每次确定第i小的元素下标，然后和i位置上的元素交换
 *时间复杂度：n2
 */
public class SelectionSort {
    public static void sort(int[] array) {
        //第一层循环代表第i个位置
        for (int i = 0; i < array.length-1; i++) {
            //第二层循环代表做对比的数字
            int minIndex =i;
            for (int j = i+1; j < array.length; j++) {
//                if (array[j]<array[i]){
//                    SortTest.exchange(array,i,j);//在这里只记录下标就可以了，可以大大减少交换次数
//                }
                if (array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            SortTest.exchange(array,i,minIndex);

        }
    }
}
