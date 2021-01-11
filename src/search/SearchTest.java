package search;

import sort.SortTest;

public class SearchTest {
    public static void main(String[] args) {
        int[] array = SortTest.initArray(100);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
        System.out.println(SequentialSearch.SSearch(array, 7));
    }
}
