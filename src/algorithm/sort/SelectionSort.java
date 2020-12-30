package algorithm.sort;

/**
 * 选择排序
 * 比较1和2，1和3，1和4。。。
 *    2和3，2和4，2和5。。。
 * 每次确定第i个元素
 *时间复杂度：n2
 */
public class SelectionSort {
    public static void sort(int[] array) {
        //第一层循环代表第i个位置
        for (int i = 0; i < array.length-1; i++) {
            //第二层循环代表做对比的数字
            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[i]){
                    SortTest.exchange(array,i,j);
                }
            }
        }
    }
}
