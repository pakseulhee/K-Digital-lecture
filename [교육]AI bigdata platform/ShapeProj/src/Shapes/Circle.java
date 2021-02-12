package Shapes;

public class Circle extends Shape {
	Point center;
	int radius;
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Circle() {}
	public Circle(String color, Point center, int radius) {
		super(color);
		this.center = center;
		this.radius = radius;

	}
	public Circle(String color, int x, int y, int radius) {
		super(color);
		this.center = new Point(x,y);
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("[Circle-color:"+ getColor()+",center:"+center.xy()+",radius:"+getRadius());
	}
}
/* 출력결과
 * [Circle-color:green,center:(10,10),radius:5]
 * [Circle-color:red,center:(20,20),radius:5]
 * [Rectangle-color:yellow,width:5,height:10]
 * [Triangle-color:blue,pos1:(3,3),pos2:(7,7),pos3:(2,2)]
 * [Triangle-color:orange,pos1:(20,20),pos2:(15,15),pos3:(17,17)] 
 * */
