package sec05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(100, "hong");
		hm.put(101, "park");
		hm.put(102, "song");
		System.out.println(hm.get(102));

		Set<Map.Entry<Integer,String>> eset = hm.entrySet();
		Iterator<Map.Entry<Integer, String>> sit = eset.iterator();
		while(sit.hasNext()) {
			Map.Entry<Integer, String>entry = sit.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("\t"+key+":"+value);
		}
		System.out.println();
	}
}
