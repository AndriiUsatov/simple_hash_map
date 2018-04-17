import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
//        map.put(1, "first");
//        map.put(2, "second");
//        map.put(3, "third");
//        map.put(4, "fourth");
//        map.put(5, "fifth");
//        System.out.println("Size must be 5:  " + map.size());
//        for(int i = 6; i < 30; i++){
//            map.put(i,String.valueOf(i)+ "hey");
//        }
//        System.out.println("Size must be 29:    " + map.size());
//        map.put(1,"heyheyhey");
//        for (SimpleHashMap.Pair<Integer, String> entry : map.pairSet()) {
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
//        }
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"first");
        System.out.println(map.put(1,"heyheyhey"));
        for(Map.Entry<Integer,String> entry : map.entrySet())
            System.out.println(entry.getKey() + "\t" + entry.getValue());
    }
}
