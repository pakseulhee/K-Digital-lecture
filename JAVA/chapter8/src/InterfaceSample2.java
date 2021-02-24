interface DoubleClickable{
	void idoubleClick();
}
class Button {
	Clickable c;
	DoubleClickable dc;
	public void click() {
		System.out.println("꾹 눌러짐.");
		if(c!=null) {
			c.iclick();
		}
	}
	public void doubleClick() {
		if(dc!=null) {
			dc.idoubleClick();
		}
	}
	public void addClickListener(Clickable c) {
		this.c = c;
	}
	public void addDoubleClickListener(DoubleClickable c) {
		this.dc = dc;
	}
	
	interface Clickable{
		void iclick();
	}
}

public class InterfaceSample2 {

	public static void main(String[] args) {
		Button libtn = new Button();
		libtn.addClickListener(new Button.Clickable() {
			@Override
			public void iclick() {
				System.out.println("로그인 처리");
			}
		});
		libtn.click();
		
		Button joinBtn = new Button();
		joinBtn.addClickListener(new Button.Clickable() {
			@Override
			public void iclick() {
				System.out.println("회원가입 처리");
			}
		});
		joinBtn.click();
	}
}
