package dto;
public class StudentDTO {
	int No;
	String name;
	String det;
	String addr;
	String tel;

	public StudentDTO() {}
	public StudentDTO(int No, String name,String det,String addr, String tel) {
		this.No=No;
		this.name=name;
		this.det=det;
		this.addr=addr;
		this.tel=tel;

	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDet() {
		return det;
	}
	public void setDet(String det) {
		this.det = det;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
