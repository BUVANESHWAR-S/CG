import java.util.Stack;


public class stack_srt_rec {
    private Stack<Integer> st;

    public stack_srt_rec(){
        st = new Stack<>();
    }
    public void sort(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            sort(st);
            insert_sorted(st, temp);
        }
    }
    public void insert_sorted(Stack<Integer> st, int temp){
        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
        }
        else{
            int val = st.pop();
            insert_sorted(st, temp);
            st.push(val);
        }
    }
    public void display(Stack<Integer> st){
        for(int num : st){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        stack_srt_rec obj1 = new stack_srt_rec();
        Stack<Integer> stack =new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        obj1.display(stack);
        System.out.println("after sorting");
        obj1.sort(stack);
        obj1.display(stack);
    }
}
