package sort;

public interface Sort {

    void sort(int[] arr);


    default void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    default int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int value:arr){
            if (value<min){
                min=value;
            }
        }
        return min;
    }

    default int getMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int value:arr){
            if (value>max){
                max=value;
            }
        }

        return max;
    }
}
