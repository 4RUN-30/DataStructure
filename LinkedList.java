import java.util.NoSuchElementException;

public class LinkedList<E>{
    private Node head;
    private Node tail;
    private int len;
    private class Node{
        Node next;
        E data;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    // Adding an element at the beginning take O(1)
    public void prepend(E data){
        Node n = new Node(data);
        if(head == null) {
            tail = n;
        }
        else{
            n.next=head;
        }
        head = n;
        len++;
    }

    // Adding an element at the end take O(1)
    public void append(E data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }
        else{
            tail.next = n;
        }
        tail = n;
        len++;
    }

    // Adding an element at given index takes O(N) due to traversing but inserting is O(1)
    public void insert(int index,E data){
        Node n = new Node(data);
        if(index>len || index<0){
            throw new IndexOutOfBoundsException("Cant insert bro");
        }
        else{
            if(index==0){
                this.prepend(data);
            }
            else{
                int i=0;
                Node node = head;
                while(i<index-1){
                    node = node.next;
                    i++;
                }
                n.next = node.next;
                node.next = n;
            }
        }
        len++;
    }

    // Deleting an element at the given index takes O(N) due to the traversing but deleting is O(1)
    public void delete(int index){
        if(index<0 || index>len){
            throw new IndexOutOfBoundsException("cant delete bro");
        }
        else{
            if(index==0) head = head.next;
            else{
                int count = 0;
                Node node = head;
                while(count<index-1){
                    count++;
                    node = node.next;
                }
                node.next = node.next.next;
            }
        }
        len--;
    }

    // Accessing an element at the given index takes O(N)
    public E get(int index){
        if(index>len || index<0){
            throw new IndexOutOfBoundsException("Cant access bro");
        }
        else{
            if(index==0){
                return head.data;
            }
            else{
                int i=0;
                Node node = head;
                while(i<index){
                    node = node.next;
                    i++;
                }
               return node.data;
            }
        }
    }
    // searching an element takes O(N)
    public int search(E data){
        int index = 0;
        Node node = head;
        while(node.data!=null){
            if(node.data == data) return index;
            node = node.next;
            index++;
        }
        throw new NoSuchElementException("No element bro");
    }

    public String toString(){
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(node!=null){
            sb.append(node.data).append(",");
            node = node.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return new String(sb);
    }
}