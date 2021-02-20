import Shapes.Circle;
import Shapes.IAngle;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.Triangle;

public class ShapeSet {
	Shape[] shapes = new Shape[100];
	int cnt;
	
	public void addShape(Shape shape) {
		shapes[cnt++] = shape;
	}

	public void allShapeDraw() {
		for(int i=0; i<cnt; i++) {
			shapes[i].draw();
		}
	}
	public void angleShape() {
		for(int i=0; i<cnt; i++) {
			if(shapes[i] instanceof IAngle) {
				shapes[i].draw();
			}
		}

	}
	public static void main(String[] args) {
		ShapeSet set = new ShapeSet();
//		set.addShape(new Shape()); //불가능해요. 추상으로 마든거라서 shape 자체는 객체 생성이 안돼요.
		set.addShape(new Circle("green", new Point(10,10), 5));
		set.addShape(new Circle("red", 20, 20, 5));
		set.addShape(new Rectangle("Yellow", 5, 10));
		set.addShape(new Triangle("blue", new Point(3,3), new Point(7,7), new Point(2,2)));
		set.addShape(new Triangle("orange",20,20,15,15,17,17));

		set.angleShape();
	}
}

