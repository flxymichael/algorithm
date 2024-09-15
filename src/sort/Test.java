package sort;

public class Test {

    public static void main(String[] args) {
        int[] arr = new GenerateArray().generateRandomArray(100);
        Sort test = new CountSort();


        System.out.println("原始数组");
        test.printArray(arr);


        test.sort(arr);


        System.out.println("排序后数组");
        test.printArray(arr);
    }
}
