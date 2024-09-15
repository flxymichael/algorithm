package sort;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
    }


    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    public int partition(int[] arr, int left, int right) {

        int pivot = arr[right];
        int slow = left;
        int fast = left;

        while (fast < right) {
            if (arr[fast] < pivot) {
                swap(arr, slow, fast);
                slow++;
            }
            fast++;

        }
        swap(arr, slow, right);

        return slow;
    }
}
