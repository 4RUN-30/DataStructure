public class HashMap<K extends Object, V extends Object> {
    // Creating a class which stores the key, value, and pointer to next

    private KeyValue<K,V>[] value;
    private int len;

    // Default constructor creates a hashmap of size 16
    public HashMap(){
        value = new KeyValue[16];
        this.len = 0;
    }

    //parameterized constructor creates a hashmap size of users' wish
    public HashMap(int capacity){
        value = new KeyValue[capacity];
        this.len = 0;
    }

    // function used to hash the key which has a time complexity of O(1)
    private int hashFunction(K k) {
        return Math.abs(k.hashCode()) % this.value.length;
    }

    // Adding a key-value pair which has time complexity of O(1) (but O(n) at worst case which is during collisions)
    public boolean put(K key,V value){
        int hashIndex = hashFunction(key);
        KeyValue keyValue = new KeyValue(key,value);
        if(this.value[hashIndex]==null) this.value[hashIndex] = keyValue;
        else{
            KeyValue node = this.value[hashIndex];
            while(node.next!=null){
                node = node.next;
            }
            node.next = keyValue;
        }
        len++;
        return true;
    }

    // Searching a value based on a key that has a time complexity of O(1) (but O(n) at worst case which is during collision)
    public V get(K key){
        int hashIndex = hashFunction(key);
        KeyValue keyValue = this.value[hashIndex];
        if(keyValue!=null){
            boolean flag = false;
            while (keyValue!=null){
                if(keyValue.key.equals(key)){
                    return (V) keyValue.value;
                }
                keyValue = keyValue.next;
            }
        }
        return null;
    }

    // Deleting key value pair from the hashmap which has a time complexity of O(1) (but O(n) at the worst case which is during collision)
    public boolean delete(K key){
        int hashIndex = hashFunction(key);
        KeyValue keyValue = this.value[hashIndex];
        if(keyValue.key.equals(key)){
            this.value[hashIndex] = keyValue.next;
        }
        else{
            while(!keyValue.next.key.equals(key)){
                keyValue = keyValue.next;
            }
            keyValue.next = keyValue.next.next;
        }
        return true;
    }

    // To print all the values in the hashmap which is O(n)
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0;i<this.value.length;i++){
            if(this.value[i]!=null) {
                KeyValue node = this.value[i];
                while(node != null){
                    sb.append(node.key).append(":").append(node.value).append(",");
                    node = node.next;
                }
            }
        }
        if(sb.length()<2){
            return "{}";
        }
        sb.setCharAt(sb.length()-1,'}');
        return new String(sb);
    }

    class KeyValue<K,V>{
        K key;
        V value;
        KeyValue next;
        KeyValue(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
}
