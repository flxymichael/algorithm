package Stack;

import java.util.Stack;

public class MinContain {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int num){
        data.push(num);
        if (min.empty()){
            min.push(num);
        }else {
            min.push(min.peek()<num?min.peek():num);
        }
    }
    public void pop(){
        min.pop();
        data.pop();
    }
    public int top(){
        return data.peek();
    }
    public int min(){
        return min.peek();
    }
}
