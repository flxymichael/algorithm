package sort;

/**
 * 希尔排序
 * 也叫缩小增量排序
 * 是一种改良的插入排序
 * 通过将元素按照不同的增量（递减）分为不同的组（逻辑分组，实际上还是在同一个数组内），然后对组内元素进行插入排序
 * 不稳定排序：相同的元素可能分布在不同的组里，在分组排序过程中可能会影响到他们的顺序
 * 时间复杂度为n1.3-n1.5，证明很复杂
 */
public class ShellSort {
    public static void sort(int[] array) {
        //取增量=arr.len/2,并逐步/2直到增量为1，此时整个数组只有一个分组即他自身
        for (int gap = array.length/2; gap>0;gap/=2){
            //每一个分组内的元素是.....arr[i-2*gap],arr[i-gap],arr[i+gap],arr[gap+2*gap].....
            for (int i = gap;i<array.length;i++){
                //每一个分组内部实行插入排序
                //不是一个分组排完再排另一个，而是没组排一个元素，比如对于arr[2],arr[3],arr[4]
                //轮到arr[2]，时，就先在arr[2]所在在分组给arr[2]排好序
                //轮到arr[3]，时，就先在arr[2]所在在分组给arr[3]排好序
                //轮到arr[4]，时，就先在arr[2]所在在分组给arr[4]排好序

                //每次只对i之前的元素进行排序
                //比如gap=4，i,i+1,i+2是不同的逻辑分组
                for (int j = i;j>=gap&&array[j]<array[j-gap];j-=gap){
                    SortTest.exchange(array,j,j-gap);
                }
            }

        }

    }
}
