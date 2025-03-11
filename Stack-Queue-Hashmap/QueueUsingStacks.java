import java.util.Stack;

class QueueUsingStacks{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public QueueUsingStacks(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void push(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    public int pop(){
        return s1.pop();
    }
    public int peek(){
        return s1.peek();
    }
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingStacks q=new QueueUsingStacks();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
    }
}