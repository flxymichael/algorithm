package sort;

/**
 * 对于完全二叉树中的第n个元素
 * 其左子节点为2n+1，右子节点为2n+2
 * 其父节点为(n-1)/2
 *
 */
public class HeapSort implements Sort{
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        //最后有一个叶子节点坐标为n-1
        //那么其父节点的坐标，也就是最后一个非叶子结点的坐标就是((n-1)-1)/2
        //我们从此处开始，自底向上,对每一个节点进行根化，最终构建最大堆
        for (int i = (n-1-1)>>1; i>=0; i--) {
         heapify(arr,n,i);
        }

        //堆顶元素坐标为0，逐次将其与堆尾元素交换，并重新堆化，新堆大小为i
        for (int i =n-1; i >0; i--) {
            swap(arr,i,0);
            heapify(arr,i,0);
        }


    }

    public void heapify(int[] arr,int n,int i){
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        if (leftChild<n&&arr[leftChild]>arr[largest]){
            largest=leftChild;
        }
        if (rightChild<n&&arr[rightChild]>arr[largest]){
            largest=rightChild;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }
}
