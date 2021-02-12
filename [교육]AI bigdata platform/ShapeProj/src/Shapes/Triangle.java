package Shapes;

public class Triangle extends Shape implements IAngle{
	Point[] pos = new Point[3]; //객체 3개 아니고 레퍼런스 3개임!
	//객체는 생성자에서 만드는 것이다.
	
	public Triangle() {}
	public Triangle(String color, Point pos1, Point pos2, Point pos3) {
		super(color);
		pos[0] = pos1;
		pos[1] = pos2;
		pos[2] = pos3;
	}
	public Triangle(String color, int x1, int y1, int x2, int y2, int x3 ,int y3) {
		super(color);
		pos[0] = new Point(x1, y1);
		pos[1] = new Point(x2, y2);
		pos[2] = new Point(x3, y3);
	}
	
	@Override
	public void draw() {	
		System.out.println("[Triangle-color:"+ getColor()+",pos1:"+pos[0].xy()+",pos2:"+pos[1].xy()+",pos1:"+pos[2].xy());

	}
}

/* 출력결과
 * [Circle-color:green,center:(10,10),radius:5]
 * [Circle-color:red,center:(20,20),radius:5]
 * [Rectangle-color:yellow,width:5,height:10]
 * [Triangle-color:blue,pos1:(3,3),pos2:(7,7),pos3:(2,2)]
 * [Triangle-color:orange,pos1:(20,20),pos2:(15,15),pos3:(17,17)] 
 * */
