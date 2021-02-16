package example04;

public class NestedClassExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		Car.Tire tire = myCar.new Tire(); //인스턴스 이너클래스 생성방법
		Car.Engine engine = new Car.Engine();//인스턴스 아웃클래스 생성방법
	}
}
