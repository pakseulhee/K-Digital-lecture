package Shapes;

public class Rectangle extends Shape implements IAngle{
	int width;
	int height;
	
	public Rectangle() {}
	public Rectangle(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println("[Rectangle-color:"+ getColor()+",width:"+getWidth()+",height:"+getHeight());
	}
}
