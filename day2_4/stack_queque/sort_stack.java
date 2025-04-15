import java.util.Stack;
import java.util.*;
public class sort_stack {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public sort_stack(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    public void crt_stack(int[] arr){
        for(int i = 0; i<arr.length; i++){
            st1.push(arr[i]);
        }

        display(sort_stck(st1));
    }
    public Stack<Integer> sort_stck(Stack<Integer> st1){
        if(st1.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(!st1.isEmpty()){
            int temp = st1.pop();
            while (!st2.isEmpty() && st2.peek() < temp) {
                st1.push(st2.pop());
            }
            st2.push(temp);
        }
        return st2;
    }
    public void display(Stack<Integer> st1){
        while(!st1.isEmpty()){
            System.out.println(st1.pop());
        }
    }

    public static void main(String[] args){
        sort_stack obj1 = new sort_stack();

        obj1.crt_stack(new int[]{1,23, 4, 2, 43, 22, 54, 0});
    }
}
