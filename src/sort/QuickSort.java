package sort;

/**
 * 快速排序
 * 取任意元素为index，大于index的去右边，小于index的去左边，在对左、右进行递归快排
 * 所以说快速排序的本质就是确定index的位置
 * 时间复杂度：n2
 */
public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array,0,array.length-1);
    }
    public static void quickSort(int[] arr,int low,int high){
        if (low>=high)return;
        int indexPosition =getIndexPosition(arr, low, high);
        quickSort(arr,low,indexPosition-1);
        quickSort(arr,indexPosition+1,high);
    }

    //确定index位置
    public static int getIndexPosition(int[] arr,int low,int high){
        //如果每次选的这个index都是数组中最大的，将导致算法时间复杂度退化为n2
        int index = arr[low];//随机的话会更好一点
        while (low<high){
            while (low<high&&arr[high]>=index){
                high--;
            }
            arr[low] = arr[high];
            while (low<high&&arr[low]<=index){
                low++;
            }
            arr[high]=arr[low];
        }
        //此时high和low是相等的,且这也就是index中的正确位置：其左边的数字都比他小，右边的数字都比他大
        arr[high]=index;
        return high;
    }
}
