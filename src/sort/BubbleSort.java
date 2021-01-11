package sort;

/**
 * 冒泡排序
 * 比较1和2，2和3，3和4，，，每次将最大的移动到最后，或者将最小的移动到最前面
 * 时间复杂度：n2
 */
public class BubbleSort {
    public static void sort(int[] array) {
        //第一层循环代表需要进行循环对比的次数，，每次循环只能确定一个位置
        for (int i = 0; i < array.length-1; i++) {
            //第二层循环是真正的对比
            for (int j=0; j < array.length-1-i; j++) {
                    if (array[j]>array[j+1]){
                        SortTest.exchange(array,j,j+1);
                    }
            }
        }
    }
}
