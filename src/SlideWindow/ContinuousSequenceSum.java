package SlideWindow;

import java.util.ArrayList;

public class ContinuousSequenceSum {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(3));
    }
    public  static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int l =1;
        int r =1;
        int tmp =0;
        while (l<=sum>>1){
            if (tmp<sum){
                tmp+=r;
                ++r;
            }else if (tmp>sum){
                tmp-=l;
                ++l;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i < r; i++) {
                    list.add(i);
                }
                lists.add(list);
                tmp-=l;
                tmp+=r;
                r++;
                l++;
            }
        }
        return lists;
    }
}
