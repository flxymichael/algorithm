package algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,7,8,9,231,4552,242264,663566353};
        System.out.println(bs(array, -123));
    }
    public static int bs(int[] nums,int target){
        if (nums.length<=0)return -1;
        int start = 0;
        int end = nums.length-1;
        while (end>=start){
            int mid = (start+end)/2;
            if (nums[mid]==target)return mid;
            if (nums[mid]>target)end=mid-1;
            if (nums[mid]<target)start=mid+1;
        }
        return -1;
    }

}
