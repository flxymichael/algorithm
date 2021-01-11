package search;

public class SequentialSearch {
    public static int SSearch(int[] nums,int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target)return i;
        }
        return -1;
    }
}
