package employeemanagement.model;

import java.util.Date;

public class ApplyLeave {
	
	private int id;
	private Date fromDate;
	private Date toDate;
	private String reason;
	private int empId;
	private String status;
	private String letter;
	private String month;
	private String typeofLeave;
	
	
	
	
	@Override
	public String toString() {
		return "ApplyLeave [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", reason=" + reason
				+ ", empId=" + empId + ", status=" + status + ", letter=" + letter + ", month=" + month
				+ ", typeofLeave=" + typeofLeave + "]";
	}
	public String getTypeofLeave() {
		return typeofLeave;
	}
	public void setTypeofLeave(String typeofLeave) {
		this.typeofLeave = typeofLeave;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}

}
