package sec02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListObjExample {

	public static void main(String[] args) {
		List<Korean> kors = new ArrayList<Korean>();
		Korean k = new Korean("123124","park","seoul");
		kors.add(k);
		kors.add(new Korean("123124","park","seoul"));
		kors.add(new Korean("135313","lee","incheon"));
		kors.add(new Korean("462341","song","songpa"));
	}
}
