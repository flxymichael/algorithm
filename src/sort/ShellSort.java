package sort;

public class ShellSort implements Sort{
    @Override
    public void sort(int[] arr) {
        int d = arr.length / 2;

        while (d >0)  {
            for (int i = d; i < arr.length; i++) {
                int key = arr[i];
                int j = i - d;
                while (j >= 0 && arr[j] > key) {
                    arr[j + d] = arr[j];
                    j -= d;
                }
                arr[j + d] = key;
            }
            d /= 2;
        }
    }
}
