package SlideWindow;

import java.util.ArrayList;
import java.util.HashMap;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
// 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,16};
        int sum = 10;
        System.out.println(FindNumbersWithSum(arr, sum));
    }
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] < sum) {
                ++l;
            } else if (array[l] + array[r] > sum) {
                --r;
            } else {
                ArrayList<Integer> integers = new ArrayList<Integer>();
                integers.add(array[l]);
                integers.add(array[r]);
                lists.add(integers);
                l++;
                --r;
            }
        }
        if (lists.size()==0)return new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(0) * lists.get(i).get(0) < min) {
                flag=i;
                min=lists.get(i).get(0) * lists.get(i).get(0);
            }
        }
        return lists.get(flag);
    }
}
