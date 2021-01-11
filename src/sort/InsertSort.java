package sort;

/**
 * 插入排序
 * 从第二项起，将后端的未排序元素插入到已排序元素中,所以在部分元素有序的情况下性能较好
 * 稳定排序
 * 时间复杂度：n2
 */
public class InsertSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j>0){
                if (array[j]<array[j-1]){
                    SortTest.exchange(array,j,j-1);
                    j--;
                }else {
                    break;
                }
            }
        }
    }
}
