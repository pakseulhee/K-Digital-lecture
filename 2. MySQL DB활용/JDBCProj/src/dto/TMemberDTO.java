package dto;

public class TMemberDTO {
	String id;
	String pwd;
	String name;
	String email;
	String joindate;
	public TMemberDTO() {}
	public TMemberDTO(String id, String pwd, String name, String email, String joindate) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.joindate = joindate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "ID: "+id+", PWD: "+pwd+", NAME: "+name+", EMAIL: "+email+", JOINDATE: "+joindate;
	}
	
}
