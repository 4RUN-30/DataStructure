import java.util.NoSuchElementException;

public class Queue<E> {
    private Node top;
    private Node bottom;
    int len;

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    // Time complexity : O(n)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Node node = top;
        while(node!=null){
            sb.append(node.data).append(",");
            node = node.next;
        }
        sb.setCharAt(sb.length()-1,'}');
        return new String(sb);
    }

    // Time complexity : O(1)
    public E peek(){
        if(top==null){
            throw new NoSuchElementException("cant deque bro");
        }
        return top.data;
    }

    // Time complexity : O(1)
    public void enqueue(E data){
        Node n = new Node(data);
        if(top == null) top = n;
        else  bottom.next = n;
        bottom = n;
        len++;
    }

    // Time complexity : O(1)
    public E dequeue(){
        E res;
        if(top==null){
            throw new NoSuchElementException("cant deque bro");
        }
        else{
            res = top.data;
            top = top.next;
        }
        return res;
    }

}
