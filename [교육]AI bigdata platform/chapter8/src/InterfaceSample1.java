public class InterfaceSample1 {
	public static void sayHello(MessageBean bean) {
		bean.sayHello("java");
	}
	public static void main(String[] args) {
//		MessageBean mb = new MesageBean_kr();
		sayHello(new MessageBean_kr()); //객체를 얼마든지 바꿔치기할  수 있음
		sayHello(new MessageBean_En()); //객체를 얼마든지 바꿔치기할  수 있음

	}
}
