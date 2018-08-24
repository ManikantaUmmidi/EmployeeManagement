package employeemanagement.model;

public class Dept {
	
	private int id;
	private String dept;
	public Dept() {
		super();
	}
	public Dept(int id, String dept) {
		super();
		this.id = id;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dept=" + dept + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

}
