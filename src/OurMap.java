import java.util.*;


public class OurMap{
    private int capacity;
    private int size;
    private final int ININTIAL_SIZE= 5;
    
    private List<MapNode<K,V>> bucket;

    public OurMap(){
        bucket = new ArrayList<>();
        capacity = ININTIAL_SIZE;
        for(int i=0; i<capacity; i++){
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return hashCode % capacity;

    }
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while(head!= null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.put(bucketIndex,value);
            }
            head = head.next;
        }
        size++;
        MapNode<K,V> newEntry = new MapNode<K,V>(key,value);
        head = bucket.getBucketIndex(key);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);
    }

    public void remove(K key){
        MapNode<K,V> head = bucket.getBucketIndex(key);
        MapNode<K,V> prev = null;

        while(head !=null){
            if(head.key.equals(key)){
                if(prev = null){
                    bucket.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }

                head.next = null;
                size--; 
                break;
            }
            prev = head;
            head = head.next;
        }

    }
    private class MapNode<K,V>{
        K key;
        V value;
        MapNode<K,V> next;

        public MapNode(K key , V value){
            this.key = key;
            this.value = value;

        }
    }



}
