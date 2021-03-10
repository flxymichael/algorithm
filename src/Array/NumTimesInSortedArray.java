package Array;

//统计一个数字在升序数组中出现的次数。
//二分查找思想
public class NumTimesInSortedArray {

    public int GetNumberOfK(int[]arr,int k){
        if (arr.length<=0||arr==null)return -1;
        int low = 0;
        int high = arr.length-1;
        int count = 0;
        while (low<=high){
            int mid = (low+high)>>1;
            if (arr[mid]>k){
                high=mid-1;
                continue;
            }
            if (arr[mid]<k){
                low=mid+1;
                continue;
            }
            count++;
            int pre= mid-1;
            int fix= mid+1;
            while (pre>=0){
                if (arr[pre]==k){
                    count++;
                    pre--;
                }else {
                    break;
                }
            }
            while (fix<=arr.length-1){
                if (arr[fix]==k){
                    count++;
                    fix++;
                }else {
                    break;
                }
            }
            return count;
        }
        return -1;
    }
}
