package offer.sword;

public class BitOperation {
    public static void main(String[] args) {

    }
    public int Add(int num1,int num2) {
       //位运算中，进位就是与运算再进一位，1+1=进位1，不考虑进位的和就是异或运算
        while(num2!=0){
            int c = (num1&num2)<<1;//进位
            num1^=num2;//不考虑进位的和
            num2=c;
            //在下一轮循环后，num1为 不考虑进位的和，num2为进位，继续求和，直到进位为0
        }
        return num1;
    }

}
