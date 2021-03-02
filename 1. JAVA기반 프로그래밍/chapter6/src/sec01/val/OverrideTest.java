package sec01.val;

class Point{
	int x, y;
	Point(){}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	String getLocation() {
		return "x:"+ x + ", y:"+y;
	}
}
class Point3D extends Point{
	int z;
	Point3D(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	String getLocation() {
		return super.getLocation() + ", z:"+ z;
	}
}

public class OverrideTest {

	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		System.out.println(p1.getLocation());
	}
}
