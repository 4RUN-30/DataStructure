public class DoublyLinkedList<E> {
    Node head;
    Node tail;
    int len;
    private class Node{
        Node next;
        Node prev;
        E data;
        Node(E data){
            this.data = data;
        }
    }
    // Adding an element at the end of the doubly linked list take O(1)
    public void append(E data){
        Node n = new Node(data);
        if(head==null && tail==null){
            head = n;
        }
        else{
            tail.next = n;
            n.prev = tail;
        }
        tail = n;
        len++;
        System.out.println(len);
    }

    // Adding an element at the beginning of the doubly linked list take O(1)
    public void prepend(E data){
        Node n = new Node(data);
        if(head == null){
            tail = n;
        }
        else{
            n.next = head;
            head.prev = n;
        }
        head = n;
        len++;
        System.out.println(len);
    }

    // Adding an element at the given index of the doubly linked list take O(N) due to the traversing but insertion takes O(1)
    public void insert(int index,E data){
        int count;
        Node node;
        Node n = new Node(data);
        if(index<len/2){
            if(index ==0){
                prepend(data);
            }
            else{
                count =0;
                node = head;
                while(count<index-1){
                    node = node.next;
                    count++;
                }
                n.next = node.next;
                n.prev = node;
                node.next = n;
                n.next.prev = n;
                len++;
            }
        }
        else{
            if(index == len){
                append(data);
            }
            else{
                node = tail;
                count = len-1;
                while(count>index){
                    node = node.prev;
                    count--;
                }
                n.next = node;
                n.prev = node.prev;
                node.prev = n;
                n.prev.next = n;
                len++;
            }
        }
        System.out.println(len);
    }

    // Deleting an element at the given index of the doubly linked list take O(N) due to traversing but deleting takes O(1)
    public void delete(int index){
        int count;
        if(index<len/2) {
            if(index==0){
                head = head.next;
                head.prev = null;
            }
            else{
                Node node = head;
                count = 0;
                while(count<index-1){
                    count++;
                    node = node.next;
                }
                node.next.next.prev = node;
                node.next = node.next.next;
            }
        }
        else{
            System.out.println(tail.data);
            System.out.println(len);
            if(index == len-1){
                tail = tail.prev;
                tail.next = null;
            }
            else{
                Node node = tail;
                count = len-1;
                while(count>index+1){
                    node = node.prev;
                    count--;
                }
                node.prev.prev.next = node;
                node.prev = node.prev.prev;
            }
        }
        len--;
    }

    // Searching an element in the doubly linked list take O(N)
    public int search(E data){
        Node node = head;
        int index = 0;
        while(node!=null){
            if(node.data == data) return index;
            index++;
            node = node.next;
        }
        return -1;
    }

    // Accessing an element at the given index of the doubly linked list take O(N) due to the traversing
    public E get(int index){
        if(index<0 || index>=len){
            throw new IndexOutOfBoundsException("Cant access bro");
        }
        Node node;
        int count;
        if(index>len/2){
            System.out.println("back");
            count = len-1;
            node = tail;
            while (count>index){
                node = node.prev;
                count--;
            }
        }
        else{
            count =0;
            node = head;
            while(count<index){
                node = node.next;
                count++;
            }
        }
        return node.data;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        Node node = head;
        while(node!=null){
            res.append(node.data+",");
            node = node.next;
        }
        res.setCharAt(res.length()-1,']');
        return new String(res);
    }
}
