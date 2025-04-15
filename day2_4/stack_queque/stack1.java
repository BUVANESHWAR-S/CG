import java.util.Stack;

import javax.management.RuntimeErrorException;

public class stack1{
    private Stack<Integer> stk1;
    private Stack<Integer> stk2;

    public stack1(){
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    public void enqueque(int n){
        stk1.push(n);
    }
    public int dequeque(){
        if(isEmpty()){
            throw new RuntimeException("queque is empty");
        }
        if(stk2.isEmpty()){
            while (!stk1.isEmpty()) {
                    stk2.push(stk1.pop());
            }
        }
        
        return stk2.pop();
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("queque is empty");
        }
        if(stk2.isEmpty()){
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }
    public boolean isEmpty(){
        return (stk1.isEmpty() && stk2.isEmpty());
    }
    public static void main(String[] args) {
        stack1 obj1 = new stack1();

        obj1.enqueque(2);
        obj1.enqueque(10);
        obj1.enqueque(12);
        obj1.enqueque(24);
        obj1.enqueque(54);

        System.out.println(obj1.dequeque());
        System.out.println(obj1.peek());

    }
}