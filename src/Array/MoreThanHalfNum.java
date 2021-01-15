package Array;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(arr));
    }
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return -1;
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count==0){
                candidate = array[i];
                ++count;
            }else {
                if (candidate==array[i]){
                    ++count;
                }else {
                    --count;

                }
            }
        }
        count=0;
        for (int i : array) {
            if (i==candidate)++count;
        }
        return count>array.length>>1?candidate:-1;
    }
}
