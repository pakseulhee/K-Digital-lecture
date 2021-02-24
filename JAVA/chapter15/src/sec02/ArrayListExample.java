package sec02;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hong");
		list.add("hong");
		list.add("hong");
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
