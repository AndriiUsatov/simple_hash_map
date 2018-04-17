import java.util.*;

public class SimpleHashMap<K, V> {
    private int size = 0;
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 16;
    private static int treshold;
    private List<Pair<K, V>>[] buckets;
    private Set<Pair<K, V>> pairSet;

    public SimpleHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        initBuckets(buckets);
        pairSet = new HashSet<>();
        treshold = (int) (LOAD_FACTOR * DEFAULT_CAPACITY);
    }

    public boolean put(K key, V value) {
        if (size + 1 >= treshold)
            addNewBuckets();
        if (get(key) == null) {
            SimpleHashMap.Pair<K, V> pair = new Pair<>(key, value);
            buckets[getBucket(key)].add(pair);
            pairSet.add(pair);
            size++;
            return true;
        } else return false;
    }


    private void addNewBuckets() {
        List<Pair<K, V>>[] newBuckets = new LinkedList[buckets.length * 2];
        initBuckets(newBuckets);
        System.arraycopy(buckets, 0, newBuckets, 0, size);
        buckets = newBuckets;
        treshold = (int) (buckets.length * LOAD_FACTOR);
    }

    private void initBuckets(List[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public V get(K key) {
        V result = null;
        for (Pair<K, V> pair : buckets[getBucket(key)]) {
            result = key.equals(pair.key) ? pair.value : result;
        }
        return result;
    }

    public boolean remove(K key) {
        boolean result = false;
        for (Pair<K, V> pair : buckets[getBucket(key)]) {
            if (pair.key.equals(key)) {
                result = buckets[getBucket(key)].remove(pair);
                if (result) {
                    size--;
                    pairSet.remove(pair);
                    break;
                }
            }
        }
        return result;
    }

    public Set<Pair<K, V>> pairSet() {
        return pairSet;
    }

    public int size() {
        return size;
    }

    private int getBucket(K key) {
        return (key.hashCode() % buckets.length) - 1;
    }

//    @Override
//    public Iterator<Pair<K, V>> iterator() {
//        return null;
//    }


    public static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

//    private class SimpleHashMapIterator implements Iterator{
//        Pair<K,V> last;
//        Pair<K,V> current;
//        public SimpleHashMapIterator(){
//            getLast();
//        }
//
//        private void getLast(){
//            for (int i = buckets.length - 1; i >= 0; i--) {
//                for (int j = buckets[i].size() - 1; j >= 0; j--) {
//                    last = (Pair<K, V>) buckets[i].get(j);
//                    if(last != null){
//                        j = -1;
//                        i = -1;
//                    }
//                }
//            }
//        }
//
//        @Override
//        public boolean hasNext() {
//            return current != last;
//        }
//
//        @Override
//        public Pair<K,V> next() {
//            if(current == null){
//                current = pairSet
//            }
//
//            for (int i = ; i < buckets.length - 1; i++) {
//                for (int j = 0; j < ; j++) {
//
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public void remove() {
//            System.out.println("Nope!");
//        }
//    }
}
