package Array;

public class FirstRepeatNum {

    public int duplicate (int[] numbers) {
        // write code here
        int[] count = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (count[numbers[i]]==0){
                count[numbers[i]]++;
                continue;
            }
            return numbers[i];
        }
        return -1;
    }
}
