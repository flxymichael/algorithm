package search;

public class BinarySearch {
    public static int bs(int[] nums, int target) {
        if (nums.length <= 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            if (nums[mid] < target) start = mid + 1;
        }
        return -1;
    }

    public static int bsReverse(int[] nums, int target,int left,int right) {
        if (nums.length <= 0) return -1;
        if (left>right)return -1;
        int mid = (right+left)>>1;
        if (nums[mid]==target)return mid;
        if (nums[mid]>target){
            return bsReverse(nums,target,left,mid-1);
        }
        if (nums[mid]<target){
            return bsReverse(nums, target, left+1, right);
        }
        return -1;
    }


}
