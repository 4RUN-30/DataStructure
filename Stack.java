import java.util.NoSuchElementException;

public class Stack<E> {
    private Node top;
    int len;
    private class Node{
        Node next;
        E data;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    // Push takes time complexity of O(1)
    public void push(E data){
        Node n = new Node(data);
        if(this.top != null){
            n.next = top;
        }
        top = n;
        len++;
    }
    // Pop takes time complexity of O(1)
    public E pop(){
        if(len==0){
            throw new NoSuchElementException("Cant pop bro");
        }
        else{
            E data = this.top.data;
            top = top.next;
            len--;
            return data;
        }
    }

    // Printing stack takes time complexity of O(N)
    public String toString(){
        if(len==0) return "{}";
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

    // Peek takes time complexity of O(1)
    public E peek(){
        if(len==0){
            throw new NoSuchElementException("Cant pop bro");
        }
        return  this.top.data;
    }
}
