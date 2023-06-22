import java.util.Arrays;

public class ArrayList<E extends Object> {
     private E[] data;
     int len;

    public ArrayList() {
        this.data = (E[]) new Object[2];
        this.len = 0;
    }
    // adding at end of ArrayList is O(1) mostly sometimes you have to expand the array
    public boolean add(E data){
        len++;
        if(this.data.length<len){
            this.data = expand(this.data,this.data.length);
        }
        this.data[len-1] = data;
        return true;
    }
    private E[] expand(E[] data,int length){
        return Arrays.copyOf(data,2*length);
    }

    public String toString(){
        StringBuilder res = new StringBuilder("[");
        int i;
        for(i=0;i<this.data.length;i++){
            if(this.data[i] != null) res.append(this.data[i]).append(",");
        }
        int l = res.length();
        res.setCharAt(l-1,']');
        return new String(res);
    }
    // Access an element at index in ArrayList is O(1)
    public E get(int index){
        if(index>len-1) throw new IndexOutOfBoundsException("Cant get bro");
        return this.data[index];
    }
    // Inserting an element in ArrayList is O(n)
    public boolean insert(int index,E data){
        if(index<0 || index>len){
            throw new IndexOutOfBoundsException("Cant insert bro");
        }
        if(this.data.length==len){
            this.data = expand(this.data,this.data.length);
        }
        for(int i=len-1;i>=index;i--){
            this.data[i+1] = this.data[i];
        }
        this.data[index] = data;
        len++;
        return true;
    }
    // Deleting an element in ArrayList is O(n)
    public boolean delete(int index){
        if(index<0 || index>len){
            throw new IndexOutOfBoundsException("Cant delete bro");
        }
        for(int i=index;i<len-1;i++){
            this.data[i] = this.data[i+1];
        }
        this.data[len-1] = null;
        len--;
        return true;
    }

    // Searching in ArrayList is O(n)
    public int search(E data){
        for(int i=0;i<len;i++){
            if(this.data[i]==data) return i;
        }
        return -1;
    }

}
