package Array;

public class Array {

}

//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
// 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]
// ，B[n-1] = A[0] * A[1] * ... * A[n-2];）
//对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。

class SquareArray {
    public int[] multiply(int[] a) {
        if (a == null || a.length <= 1) {
            return null;
        }
        int[] b = new int[a.length - 1];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = a[i - 1] * b[i - 1];
        }
        int d = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            b[i] *= d;
            d *= a[i];
        }
        return b;


    }
}
