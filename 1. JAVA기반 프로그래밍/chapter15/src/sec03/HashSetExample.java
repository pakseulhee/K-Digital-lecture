package sec03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> hset = new HashSet<String>();
		hset.add("hong");
		hset.add("gil");
		hset.add("dong");
		
//		for(String name : hset) {
//			System.out.println(name);
//		}
		Iterator<String> iterator = hset.iterator();
		while(iterator.hasNext()) { //다음거에 값있니? 라는 라이브러리(결과는 T/F)
			System.out.println(iterator.next());//(다음데이터를가져오고 포지션을 다음으로 넘김)
		}
		hset.clear();
		System.out.println(hset.size());
	}

}
