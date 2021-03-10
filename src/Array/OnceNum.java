package Array;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class OnceNum {
    /*
        思路：数组中的元素先依次异或，相同为0，则得到的是两个只出现一次的数的异或结果
        对于得到的异或结果，找到其第一个为1的位
        该位为1，说明两个只出现一次的数该位不同，所以按照该位是0还是1将数组分成两部分
        这样，出现两次的数字都会分到同一个部分，而两个只出现一次的数正好被分开，再各自异或可得结果
        */
    public int[] FindNumsAppearOnce(int[] array) {
        if (array.length <= 0 || array == null) return new int[2];
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            flag ^= array[i];
        }

        int index = 0;
        for (; index < 32; index++) {
            if (((flag >> index) & 1) == 1) break;
        }

        int a = 0;
        int b = 0;

        for (int i : array) {
            if (((i >> index) & 1) == 1) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        int[] result = new int[2];
        result[0] = Math.min(a, b);
        result[1] = Math.max(a, b);
        return result;
    }

    public static void main(String[] args) {
        System.out.println((6 >> 1)&1);
    }
}
