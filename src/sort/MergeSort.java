package sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int m = (l + r) >> 1;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];

        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= m) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        for (int p = 0; p < tmp.length; p++) {
            arr[l + p] = tmp[p];
        }
    }
}
