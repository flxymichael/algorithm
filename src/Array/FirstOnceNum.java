package Array;

import java.util.BitSet;
import java.util.HashMap;

public class FirstOnceNum {
    public static void main(String[] args) {
        String s = "google";
        System.out.println(FirstNotRepeatingChar(s));
        System.out.println(FirstNotRepeatingChar02(s));
        System.out.println(FirstNotRepeatingChar03(s));

    }
    public static int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()<=0)return -1;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for (int i = 0; i < str.length(); i++) {
            Integer count = map.get(str.charAt(i));
            if (count==null){
                count=1;
            }else {
                count ++;
            }
            map.put(str.charAt(i),count);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i))==1)return i;
        }
        return -1;
    }

    //数组代替hashmap
    public static int FirstNotRepeatingChar02(String str) {
        if (str==null||str.length()<=0)return -1;
        int[] arr  = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)]==1)return i;
        }

        return -1;
    }

    //bitset
    public static int FirstNotRepeatingChar03(String str) {
        BitSet b1 = new BitSet(128);//出现第一次为1
        BitSet b2 = new BitSet(128);//出现第二次及以上为1

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!b1.get(c)){
                b1.set(c);
            }else {
                b2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (b1.get(c)&&!b2.get(c))return i;
        }

        return -1;
    }
}
