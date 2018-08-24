package employeemanagement.model;

import java.util.Date;

public class Attendance {
	
	private int id;
	private int EmpId;
	private Date attendance;
	private String month;
	public Attendance() {
		super();
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Attendance(int id, int empId, Date attendance, String month) {
		super();
		this.id = id;
		EmpId = empId;
		this.attendance = attendance;
		this.month = month;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public Date getAttendance() {
		return attendance;
	}
	public void setAttendance(Date attendance) {
		this.attendance = attendance;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", EmpId=" + EmpId + ", attendance=" + attendance + "]";
	}
	
	

}
