package Stack;

import java.util.Stack;

public class PopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> tmp = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length) {
            if (pushA[i] == popA[j]) {
                ++i;
                ++j;
                continue;
            }
            if (tmp.empty() || popA[j] != tmp.peek()) {
                tmp.push(pushA[i++]);
                continue;
            }
            if (!tmp.empty() && popA[j] == tmp.peek()) {
                tmp.pop();
                j++;
                continue;
            }
        }
        while (j < popA.length) {
            if (tmp.empty() || popA[j] != tmp.peek()) break;
            tmp.pop();
            j++;
        }
        return tmp.empty();
    }
}
